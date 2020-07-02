package br.com.sicredi.vote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "voto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voto {
    @EmbeddedId
    private VotoId id;

    @ManyToOne
    @JoinColumn(name = "usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "pauta", insertable = false, updatable = false)
    private Pauta pauta;

    @Column(name = "voto")
    private boolean voto;

    public Voto(VotoId id, boolean voto) {
        this.id = id;
        this.voto = voto;
    }
}