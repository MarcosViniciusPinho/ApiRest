package br.com.api.handler;

import br.com.api.handler.domain.ResponseError;
import br.com.api.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ResponseError> handlerObjectNotFoundException(ObjectNotFoundException e){
        List<String> errors = ResponseError.getTransformersObjectsNotFoundToMessagesBusiness(e.getMultipleMessages());
        return this.getResponse(HttpStatus.NOT_FOUND, errors, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handlerValidateAtributes(MethodArgumentNotValidException e){
        List<String> errors = ResponseError.getTransformersObjectsToMessagesBusiness(e.getBindingResult().getAllErrors());
        return this.getResponse(HttpStatus.BAD_REQUEST, errors, e.getMessage());
    }

    private ResponseEntity<ResponseError> getResponse(HttpStatus status, List<String> errors, String messageException){
        return new ResponseEntity<>(new ResponseError(status.value(), status.getReasonPhrase(),
                errors, messageException, System.currentTimeMillis()), status);
    }

}
