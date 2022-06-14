package br.com.msofertaemprestimo.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultResponseException extends RuntimeException{

    @JsonProperty("error")
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public DefaultResponseException(String mensagem) {
        this.mensagem = mensagem;
    }
}
