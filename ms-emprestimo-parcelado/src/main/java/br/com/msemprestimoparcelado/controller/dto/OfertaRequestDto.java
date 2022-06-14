package br.com.msemprestimoparcelado.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OfertaRequestDto {

    @JsonProperty("cliente")
    private Cliente cliente;
}
