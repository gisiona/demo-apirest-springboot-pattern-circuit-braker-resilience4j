package br.com.msofertaemprestimo.service;

import br.com.msofertaemprestimo.controller.dto.OfertaParceladoResponseDto;
import br.com.msofertaemprestimo.integration.core.OfertaCoreIntegration;
import br.com.msofertaemprestimo.integration.parcelado.OfertaParceladoIntegration;
import br.com.msofertaemprestimo.model.OfertaParceladoModel;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class OfertaParceladoService {

    private final OfertaCoreIntegration ofertaCoreClient;
    private final OfertaParceladoIntegration ofertaParceladoClient;


    @CircuitBreaker(name = "calcularOfertaCB", fallbackMethod = "calcularOfertaParceladoFallback")
    public OfertaParceladoResponseDto calcular(OfertaParceladoModel ofertaParceladoModel) {
        log.info("Criando calculo oferta: {}", ofertaParceladoModel);

        Optional<OfertaParceladoResponseDto> responseDto = ofertaCoreClient.calcularOferta(getHeaders(ofertaParceladoModel.getRequestId()), ofertaParceladoModel);

        log.info("Retorno API Oferta Core: {}", responseDto);
        return responseDto.isPresent() ? responseDto.get() : OfertaParceladoResponseDto.builder().build();
    }

    public OfertaParceladoResponseDto calcularOfertaParceladoFallback(OfertaParceladoModel ofertaParceladoModel, Throwable ex){
        log.error("FallbackOfertaParcelado foi acionado. Detalhes: {}", ex.getMessage());
        log.info("Criando calculo oferta parcelado: {}", ofertaParceladoModel);
        Optional<OfertaParceladoResponseDto> responseDto = ofertaParceladoClient.calcularOferta(getHeaders(ofertaParceladoModel.getRequestId()), ofertaParceladoModel);

        log.info("Retorno API Oferta Parcelado: {}", responseDto);
        return responseDto.isPresent() ? responseDto.get() : OfertaParceladoResponseDto.builder().build();
    }

    private HttpHeaders getHeaders (String requestID){
        final HttpHeaders header = new HttpHeaders();
        header.set("requestID", requestID);
        return header;
    }
}
