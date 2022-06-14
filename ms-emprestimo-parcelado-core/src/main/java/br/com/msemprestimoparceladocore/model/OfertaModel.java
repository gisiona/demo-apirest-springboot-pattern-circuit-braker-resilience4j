package br.com.msemprestimoparceladocore.model;

import br.com.msemprestimoparceladocore.controller.dto.Cliente;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class OfertaModel {
    private Cliente cliente;
}
