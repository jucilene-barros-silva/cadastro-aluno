package br.com.fiap.cadastroaluno.exception;

public class DadosInvalidosException extends RuntimeException {

    public DadosInvalidosException() {
        super("Dados inválidos.");
    }

    public DadosInvalidosException(String message) {
        super(message);
    }

    public DadosInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }
}