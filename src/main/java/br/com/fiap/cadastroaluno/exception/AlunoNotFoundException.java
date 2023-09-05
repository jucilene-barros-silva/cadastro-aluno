package br.com.fiap.cadastroaluno.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends RuntimeException {

    public AlunoNotFoundException(String mensagem) {
        super(mensagem);
    }
}