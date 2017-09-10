package br.com.api.handler;

import br.com.api.handler.domain.ResponseError;
import br.com.api.service.exception.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handlerValidateAtributes(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getBindingResult().getAllErrors(), e.getMessage(), System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST);
    }

}
