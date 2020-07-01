package br.com.sicredi.vote.model;

import br.com.sicredi.vote.model.converter.PautaConverter;
import br.com.sicredi.vote.model.converter.UsuarioConverter;

import javax.persistence.*;

@Entity
@Table(name = "voto")
public class Voto {

    @Convert(converter = UsuarioConverter.class)
    @Column(name = "usuario")
    private Usuario usuario;

    @Convert(converter = PautaConverter.class)
    @Column(name = "pauta")
    private Pauta pauta;

    @Column(name = "voto")
    private boolean voto;

}