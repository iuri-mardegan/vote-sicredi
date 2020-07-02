package br.com.sicredi.vote.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "pauta")
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

    public Pauta(String nome, Calendar dataSessao) {
        this.nome = nome;
        this.dataSessao = dataSessao;
    }

    public Pauta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataSessao() {
        return dataSessao;
    }

    public void setDataSessao(Calendar dataSessao) {
        this.dataSessao = dataSessao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}