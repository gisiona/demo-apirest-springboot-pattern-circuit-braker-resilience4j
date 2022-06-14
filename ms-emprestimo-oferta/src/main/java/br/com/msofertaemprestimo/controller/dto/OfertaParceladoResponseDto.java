package br.com.msofertaemprestimo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class OfertaParceladoResponseDto {
    @JsonProperty("id_oferta")
    private String idOferta;

    @JsonProperty("piloto")
    private boolean piloto;

    @JsonProperty("cliente")
    private Cliente cliente;

    @JsonProperty("valor")
    private Valor valor;

    @JsonProperty("parcela")
    private Parcela parcela;

    @JsonProperty("vencimento")
    private Vencimento vencimento;
}
