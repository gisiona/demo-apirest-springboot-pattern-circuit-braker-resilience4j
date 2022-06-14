package br.com.msofertaemprestimo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OfertaParceladoRequestDto {
    @JsonProperty("cliente")
    private Cliente cliente;
}
