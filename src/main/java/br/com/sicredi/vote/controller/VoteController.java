package br.com.sicredi.vote.controller;

import br.com.sicredi.vote.exception.PautaException;
import br.com.sicredi.vote.exception.UsuarioException;
import br.com.sicredi.vote.exception.VoteException;
import br.com.sicredi.vote.model.Pauta;
import br.com.sicredi.vote.service.PautaService;
import br.com.sicredi.vote.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class VoteController {

    @Autowired
    private PautaService pautaService;
    @Autowired
    private VotoService votoService;

    @GetMapping("/pauta")
    public ResponseEntity<?> gerarPauta() {
        Pauta p = pautaService.novaPauta();
        return ResponseEntity.ok("Nova Pauta criada em " + p.getNome() + " - id: " + p.getId());
    }

    @GetMapping("/voto/{cpf}/{idPauta}/{voto}")
    public ResponseEntity<?> votosPauta(
            @PathVariable("cpf") String cpf,
            @PathVariable("idPauta") Integer idPauta,
    @PathVariable("voto") String voto
    ) throws VoteException, UsuarioException, PautaException {
        votoService.addVoto(cpf,idPauta,voto);
        return ResponseEntity.ok("Voto adicionado.");
    }

    @GetMapping("/resultado-pauta")
    public ResponseEntity<?> resultadoPauta() {

        return ResponseEntity.ok("Em Desenvolvimento.");
    }
}
