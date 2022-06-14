package br.com.msemprestimoparceladocore.service;

import br.com.msemprestimoparceladocore.controller.dto.OfertaCoreResponseDto;
import br.com.msemprestimoparceladocore.controller.dto.Parcela;
import br.com.msemprestimoparceladocore.controller.dto.Valor;
import br.com.msemprestimoparceladocore.controller.dto.Vencimento;
import br.com.msemprestimoparceladocore.model.OfertaModel;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class OfertaCalculoService {
    public OfertaCoreResponseDto calcular(OfertaModel ofertaModel) {
        return OfertaCoreResponseDto
                .builder()
                .idOferta(UUID.randomUUID().toString())
                .piloto(true)
                .cliente(ofertaModel.getCliente())
                .valor(Valor.builder()
                        .valorMinimo(new BigDecimal("20.00"))
                        .valorMaximo(new BigDecimal("3000.00"))
                        .build())
                .parcela(Parcela.builder()
                        .qtdeMinima(2)
                        .qtdeMaxima(24)
                        .valorParcelaMinimo(new BigDecimal("20.00"))
                        .valorParcelaMaximo(new BigDecimal("1000.00"))
                        .build())
                .vencimento(Vencimento.builder()
                        .dataMinima(LocalDate.now().plusDays(7))
                        .dataMaxima(LocalDate.now().plusDays(30))
                        .dataSugerida(LocalDate.now().plusDays(15))
                        .build())
                .build();
    }
}
