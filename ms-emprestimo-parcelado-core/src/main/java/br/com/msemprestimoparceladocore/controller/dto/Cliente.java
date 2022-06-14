package br.com.msemprestimoparceladocore.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class Cliente {
    @NotNull(message = "O nome é obrigatório.")
    @JsonProperty("nome")
    String nome;

    @NotNull(message = "O cpf é obrigatório.")
    @JsonProperty("cpf")
    String cpf;

    @JsonProperty("uf")
    String uf;

    @NotNull(message = "O e-mail é obrigatório.")
    @JsonProperty("email")
    String email;

    @NotNull(message = "Data de nascimento é obrigatório.")
    @JsonProperty("telefone_celular")
    String celular;

    @Min(value = 1, message = "Valor mínimo de renda mensal deve ser 1.")
    @JsonProperty("renda_mensal")
    double valorRenda;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "Data de nascimento é obrigatório.")
    @JsonProperty("data_nascimento")
    LocalDate dataNascimento;
}
