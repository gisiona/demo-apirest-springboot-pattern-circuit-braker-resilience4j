package br.com.msemprestimoparceladocore.controller;

import br.com.msemprestimoparceladocore.controller.dto.OfertaCoreRequestDto;
import br.com.msemprestimoparceladocore.controller.dto.OfertaCoreResponseDto;
import br.com.msemprestimoparceladocore.model.OfertaModel;
import br.com.msemprestimoparceladocore.service.OfertaCalculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ms_ofertas_calculo_core")
public class CalculoOfertaCoreController {

    private final OfertaCalculoService ofertaCalculoService;

    @GetMapping("health")
    public String health() {
        return "200 OK";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<OfertaCoreResponseDto> simulacaoParcelamento(@RequestBody @Valid OfertaCoreRequestDto ofertaCoreRequestDto) {

        OfertaModel ofertaModel = OfertaModel
                .builder()
                .cliente(ofertaCoreRequestDto.getCliente())
                .build();
        OfertaCoreResponseDto responseDto = ofertaCalculoService.calcular(ofertaModel);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
