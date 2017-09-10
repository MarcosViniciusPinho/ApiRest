package br.com.api.handler.domain;

import br.com.api.service.exception.ObjectNotFoundException;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ResponseError {

    private int status;
    private String description;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String messageException;
    private Long timeMiliseconds;
    private List<String> messagesBusiness;

    public ResponseError(int status, String description, List<String> messagesBusiness, String messageException, Long timeMiliseconds) {
        this.status = status;
        this.description = description;
        this.messagesBusiness = messagesBusiness;
        this.messageException = messageException;
        this.timeMiliseconds = timeMiliseconds;
    }

    public int getStatus() {
        return status;
    }

    public String getMessageException() {
        return messageException;
    }

    public Long getTimeMiliseconds() {
        return timeMiliseconds;
    }

    public String getDescription(){
        return description;
    }

    public List<String> getMessagesBusiness() {
        return messagesBusiness;
    }

    public static List<String> getTransformersObjectsToMessagesBusiness(List<ObjectError> objectErrorList){
        List<String> lista = new ArrayList<>();
        objectErrorList.forEach(error -> lista.add(error.getDefaultMessage()));
        return lista;
    }

    public static List<String> getTransformersObjectsNotFoundToMessagesBusiness(List<ObjectNotFoundException> exceptionsList){
        List<String> lista = new ArrayList<>();
        exceptionsList.forEach(error -> lista.add(error.getMessage()));
        return lista;
    }
}
