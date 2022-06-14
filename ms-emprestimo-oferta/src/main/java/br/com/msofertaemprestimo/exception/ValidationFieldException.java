package br.com.msofertaemprestimo.exception;

public class ValidationFieldException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private int status;
    public int getStatus() {
        return status;
    }

    private String campo;
    private String mensagem;


    public ValidationFieldException(int status, String campo, String mensagem) {
        super();
        this.status = status;
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getCampo() {
        return campo;
    }
}
