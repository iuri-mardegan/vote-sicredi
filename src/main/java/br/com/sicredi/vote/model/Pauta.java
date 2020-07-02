package br.com.sicredi.vote.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "pauta")
@Data
public class Pauta {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_sessao")
    private Calendar dataSessao;

    @OneToMany(mappedBy = "pauta")
    private List<Voto> votos;

    public Pauta() {
    }

    public Pauta(String nome, Calendar dataSessao) {
        this.nome = nome;
        this.dataSessao = dataSessao;
    }

}