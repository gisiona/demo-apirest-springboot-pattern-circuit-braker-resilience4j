package br.com.msemprestimoparcelado.controller;

import br.com.msemprestimoparcelado.controller.dto.OfertaRequestDto;
import br.com.msemprestimoparcelado.controller.dto.OfertaResponseDto;
import br.com.msemprestimoparcelado.model.OfertaModel;
import br.com.msemprestimoparcelado.service.OfertaCalculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ms_ofertas_calculo_parcelado")
public class CalculoOfertaParceladoController {

    private final OfertaCalculoService ofertaCalculoService;

    @GetMapping("/health")
    public String criarOferta() {
        return "200 OK";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<OfertaResponseDto> simulacaoParcelamento(@RequestBody @Valid OfertaRequestDto ofertaCoreRequestDto) {

        OfertaModel ofertaModel = OfertaModel
                .builder()
                .cliente(ofertaCoreRequestDto.getCliente())
                .build();
        OfertaResponseDto responseDto = ofertaCalculoService.calcular(ofertaModel);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
