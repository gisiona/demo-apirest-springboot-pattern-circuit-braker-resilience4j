package br.com.msemprestimoparceladocore.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data @Builder
public class Vencimento {

    @JsonProperty("data_minima")
    private LocalDate dataMinima;

    @JsonProperty("data_maxima")
    private LocalDate dataMaxima;

    @JsonProperty("data_sugerida")
    private LocalDate dataSugerida;
}
