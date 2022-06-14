package br.com.msofertaemprestimo.integration.parcelado;

import br.com.msofertaemprestimo.controller.dto.OfertaParceladoResponseDto;
import br.com.msofertaemprestimo.model.OfertaParceladoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "OfertaParceladoIntegrationClient", url = "${api.oferta.parcelado.url}")
public interface OfertaParceladoIntegration {

    @PostMapping(value = "/ms_ofertas_calculo_parcelado")
    Optional<OfertaParceladoResponseDto> calcularOferta(
            @RequestHeader final HttpHeaders headers,
            @RequestBody final OfertaParceladoModel model);
}
