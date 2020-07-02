package br.com.sicredi.vote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "pauta")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Pauta(String nome, Calendar dataSessao) {
        this.nome = nome;
        this.dataSessao = dataSessao;
    }

}