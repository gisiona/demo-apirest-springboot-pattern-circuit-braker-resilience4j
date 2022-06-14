package br.com.msemprestimoparceladocore.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data @Builder
public class Parcela {
    @JsonProperty("quantidade_minima")
    private Integer qtdeMinima;

    @JsonProperty("quantidade_maxima")
    private Integer qtdeMaxima;

    @JsonProperty("valor_minimo")
    private BigDecimal valorParcelaMinimo;

    @JsonProperty("valor_maxima")
    private BigDecimal valorParcelaMaximo;
}
