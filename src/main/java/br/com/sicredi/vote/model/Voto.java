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
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_pauta")
    private Pauta pauta;

    @Column(name = "voto")
    private boolean voto;

    public Voto(Usuario usuario, Pauta pauta, boolean voto) {
        this.usuario = usuario;
        this.pauta = pauta;
        this.voto = voto;
    }
}