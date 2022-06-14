package br.com.msemprestimoparcelado.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data @Builder
public class Valor {

    @JsonProperty("valor_minimo")
    private BigDecimal valorMinimo;

    @JsonProperty("valor_maximo")
    private BigDecimal valorMaximo;
}