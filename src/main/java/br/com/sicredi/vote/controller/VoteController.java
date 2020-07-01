package br.com.sicredi.vote.controller;

import br.com.sicredi.vote.service.PautaService;
import br.com.sicredi.vote.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class VoteController {

    @Autowired
    private PautaService pautaService;
    @Autowired
    private VotoService votoService;

    @GetMapping("/pauta")
    public ResponseEntity<?> gerarPauta(){

        return ResponseEntity.ok("Nova Pauta criada.");
    }

    @GetMapping("/voto")
    public ResponseEntity<?> votosPauta(){

        return ResponseEntity.ok("Voto adicionado.");
    }

    @GetMapping("/resultado-pauta")
    public ResponseEntity<?> resultadoPauta(){

        return ResponseEntity.ok("Voto adicionado.");
    }
}
