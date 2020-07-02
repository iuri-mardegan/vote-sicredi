package br.com.sicredi.vote.model;

import javax.persistence.*;

@Entity
@Table(name = "voto")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }
}