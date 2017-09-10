package br.com.api.handler;

import br.com.api.handler.domain.ResponseError;
import br.com.api.service.exception.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ResponseError> handlerUsuarioNaoEncontradoException(UsuarioNaoEncontradoException e){
        return new ResponseEntity<>(new ResponseError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getLocalizedMessage(), System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }

}
