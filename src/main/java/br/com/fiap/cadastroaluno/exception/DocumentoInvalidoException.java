package br.com.fiap.cadastroaluno.exception;

public class DocumentoInvalidoException extends RuntimeException {
    public DocumentoInvalidoException(String message) {
        super(message);
    }
}