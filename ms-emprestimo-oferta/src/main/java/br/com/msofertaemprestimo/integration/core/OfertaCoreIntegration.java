package br.com.msofertaemprestimo.integration.core;

import br.com.msofertaemprestimo.controller.dto.OfertaParceladoResponseDto;
import br.com.msofertaemprestimo.model.OfertaParceladoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "OfertaCoreIntegrationClient", url = "${api.oferta.core.url}")
public interface OfertaCoreIntegration {

    @RequestMapping(value = "/ms_ofertas_calculo_core", method = RequestMethod.POST)
    Optional<OfertaParceladoResponseDto> calcularOferta(
            @RequestHeader final HttpHeaders headers,
            @RequestBody final OfertaParceladoModel model);
}
