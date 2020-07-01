package br.com.sicredi.vote.service;

import br.com.sicredi.vote.model.Pauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PautaService {

    @Autowired
    private JpaRepository<Pauta, Integer> pautaRepository;

    //todo sessao de pauta em 1 minuto

}
