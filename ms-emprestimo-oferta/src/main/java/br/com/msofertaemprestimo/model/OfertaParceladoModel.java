package br.com.msofertaemprestimo.model;
import br.com.msofertaemprestimo.controller.dto.Cliente;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class OfertaParceladoModel {
    private String requestId;
    private Cliente cliente;
}
