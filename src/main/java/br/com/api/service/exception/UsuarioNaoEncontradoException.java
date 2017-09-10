package br.com.api.service.exception;

public class UsuarioNaoEncontradoException extends ObjectNotFoundException {

    public UsuarioNaoEncontradoException(String message){
        super(message);
    }

}
