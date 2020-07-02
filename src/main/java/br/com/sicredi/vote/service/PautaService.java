package br.com.sicredi.vote.service;

import br.com.sicredi.vote.model.Pauta;
import br.com.sicredi.vote.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    public Pauta novaPauta(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        return pautaRepository.save(new Pauta(sdf.format(calendar.getTime()),calendar));
    }

}
