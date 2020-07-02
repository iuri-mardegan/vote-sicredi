package br.com.sicredi.vote.service;

import br.com.sicredi.vote.dto.ResultadoPautaDTO;
import br.com.sicredi.vote.exception.PautaException;
import br.com.sicredi.vote.exception.UsuarioException;
import br.com.sicredi.vote.exception.VoteException;
import br.com.sicredi.vote.model.Pauta;
import br.com.sicredi.vote.model.Voto;
import br.com.sicredi.vote.model.VotoId;
import br.com.sicredi.vote.repository.PautaRepository;
import br.com.sicredi.vote.repository.VotoRepository;
import br.com.sicredi.vote.util.ValidaCpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;
    @Autowired
    private PautaRepository pautaRepository;

    public Voto addVoto(String cpf, Integer idPauta, String voto) throws VoteException, UsuarioException, PautaException {
        ValidaCpf.validaCpf(cpf);
        Pauta pauta = validaPautaVotacao(idPauta);
        VotoId votoId = new VotoId(cpf, pauta.getId());
        return votoRepository.save(new Voto(votoId, validaVoto(voto)));
    }

    private boolean validaVoto(String voto) throws VoteException {
        if (voto.equalsIgnoreCase("SIM")
                || voto.equalsIgnoreCase("NÃO")) {
            return voto.equalsIgnoreCase("SIM");
        }
        throw new VoteException();
    }

    private Pauta validaPautaVotacao(Integer idPauta) throws PautaException {
        Pauta pauta;
        try {
            pauta = pautaRepository.findById(idPauta).get();
        } catch (Exception e) {
            throw new PautaException("Falha ao identificar Pauta");
        }
        Calendar tempoMenosUmMinuto = Calendar.getInstance();
        tempoMenosUmMinuto.add(Calendar.MINUTE, -1);

        if (pauta.getDataSessao().getTimeInMillis() <= tempoMenosUmMinuto.getTimeInMillis()) {
            throw new PautaException("Pauta fora de sessao.");
        }
        return pauta;
    }

    public ResultadoPautaDTO getPauta(Integer idPauta) throws PautaException {
        try {
            Pauta pauta = pautaRepository.findById(idPauta).get();
            List<Voto> votoList = votoRepository.findByPauta(pauta);
            return ResultadoPautaDTO.builder()
                    .idPauta(pauta.getId())
                    .nomePauta(pauta.getNome())
                    .votosSim(votoList.stream().filter(Voto::isVoto).count())
                    .votosNao(votoList.stream().filter(voto -> !voto.isVoto()).count())
                    .build();
        } catch (Exception e) {
            throw new PautaException("Falha ao identificar Pauta");
        }
    }
}
