package br.com.sicredi.vote.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultadoPautaDTO {

    @JsonProperty("id_pauta")
    private Integer idPauta;
    @JsonProperty("nome_pauta")
    private String nomePauta;
    @JsonProperty("voto_sim")
    private long votosSim;
    @JsonProperty("voto_nao")
    private long votosNao;

}
