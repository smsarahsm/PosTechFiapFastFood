package br.com.fiap.postechfastfood.infrastructure.web.api.exceptions;

public class CpfCadastradoException extends RuntimeException {

    public CpfCadastradoException(String message) {
        super(message);
    }

    public CpfCadastradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
