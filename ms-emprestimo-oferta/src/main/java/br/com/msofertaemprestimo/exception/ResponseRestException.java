package br.com.msofertaemprestimo.exception;

import java.time.LocalDateTime;
import java.util.Date;

public class ResponseRestException  extends DefaultResponseException {

    private int status;
    private Long tamestamp;
    private LocalDateTime datetime;

    public LocalDateTime getDatetime() {
        return datetime;
    }


    public int getStatus() {
        return status;
    }


    public Long getTamestamp() {
        return tamestamp;
    }

    public ResponseRestException(int status, String mensagem, Long tamestamp) {
        super(mensagem);
        this.status = status;
        this.tamestamp = tamestamp;
        this.datetime = LocalDateTime.now();
    }

    public ResponseRestException(int status, String mensagem) {
        super(mensagem);
        this.status = status;
        this.tamestamp = new Date().getTime();
        this.datetime = LocalDateTime.now();
    }
}
