package br.com.sicredi.vote.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "voto")
@Data
public class Voto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "pauta")
    private Pauta pauta;

    @Column(name = "voto")
    private boolean voto;

    public Voto() {
    }

    public Voto(Usuario usuario, Pauta pauta, boolean voto) {
        this.usuario = usuario;
        this.pauta = pauta;
        this.voto = voto;
    }
}