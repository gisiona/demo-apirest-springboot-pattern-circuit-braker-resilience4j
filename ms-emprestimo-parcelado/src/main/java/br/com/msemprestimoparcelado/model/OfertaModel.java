package br.com.msemprestimoparcelado.model;

import br.com.msemprestimoparcelado.controller.dto.Cliente;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class OfertaModel {
    private Cliente cliente;
}
