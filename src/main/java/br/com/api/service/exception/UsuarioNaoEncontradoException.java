package br.com.api.service.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String mensagem){
        super(mensagem);
    }

}
