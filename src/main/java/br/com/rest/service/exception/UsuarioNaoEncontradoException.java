package br.com.rest.service.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String mensagem){
        super(mensagem);
    }

}
