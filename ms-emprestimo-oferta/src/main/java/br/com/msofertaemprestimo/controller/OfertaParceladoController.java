package br.com.msofertaemprestimo.controller;

import br.com.msofertaemprestimo.controller.dto.OfertaParceladoResponseDto;
import br.com.msofertaemprestimo.controller.dto.OfertaParceladoRequestDto;
import br.com.msofertaemprestimo.model.OfertaParceladoModel;
import br.com.msofertaemprestimo.service.OfertaParceladoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/ms_ofertas_emprestimo")
public class OfertaParceladoController {

    private final OfertaParceladoService ofertaParceladoService;

    @GetMapping("/health")
    public String health() {
        return "200 OK";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<OfertaParceladoResponseDto> calcularOFerta(
            @RequestHeader(value = "requestID", required = true) String requestID,
            @RequestBody @Valid OfertaParceladoRequestDto ofertaCoreRequestDto) {

        log.info("Payload: {}", ofertaCoreRequestDto);
        OfertaParceladoModel ofertaModel = OfertaParceladoModel
                .builder()
                .requestId(requestID)
                .cliente(ofertaCoreRequestDto.getCliente())
                .build();

        OfertaParceladoResponseDto responseDto = ofertaParceladoService.calcular(ofertaModel);

        return new ResponseEntity<>(responseDto, null, HttpStatus.CREATED);
    }
}
