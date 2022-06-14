package br.com.msemprestimoparcelado.service;


import br.com.msemprestimoparcelado.controller.dto.OfertaResponseDto;
import br.com.msemprestimoparcelado.controller.dto.Parcela;
import br.com.msemprestimoparcelado.controller.dto.Valor;
import br.com.msemprestimoparcelado.controller.dto.Vencimento;
import br.com.msemprestimoparcelado.model.OfertaModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class OfertaCalculoService {
    public OfertaResponseDto calcular(OfertaModel ofertaModel) {
        return OfertaResponseDto
                .builder()
                .idOferta(UUID.randomUUID().toString())
                .piloto(false)
                .cliente(ofertaModel.getCliente())
                .valor(Valor.builder()
                        .valorMinimo(new BigDecimal("20.00"))
                        .valorMaximo(new BigDecimal("3000.00"))
                        .build())
                .parcela(Parcela.builder()
                        .qtdeMinima(2)
                        .qtdeMaxima(24)
                        .valorParcelaMinimo(new BigDecimal("20.00"))
                        .valorParcelaMaximo(new BigDecimal("2000.00"))
                        .build())
                .vencimento(Vencimento.builder()
                        .dataMinima(LocalDate.now().plusDays(7))
                        .dataMaxima(LocalDate.now().plusDays(30))
                        .dataSugerida(LocalDate.now().plusDays(15))
                        .build())
                .build();
    }
}
