package br.com.msemprestimoparceladocore.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OfertaCoreRequestDto {

    @JsonProperty("cliente")
    private Cliente cliente;
}
