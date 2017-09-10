package br.com.api.handler.domain;

import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ResponseError {

    private int status;
    private String description;
    private String messageException;
    private Long timeMiliseconds;
    private List<String> messagesBusiness;

    public ResponseError(int status, String description, String messageException, Long timeMiliseconds) {
        this.status = status;
        this.description = description;
        this.messageException = messageException;
        this.timeMiliseconds = timeMiliseconds;
    }

    public ResponseError(int status, String description, List<ObjectError> objectErrorList, String messageException, Long timeMiliseconds) {
        this.status = status;
        this.description = description;
        this.messagesBusiness = this.getTransformersObjectsToMessagesBusiness(objectErrorList);
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

    private List<String> getTransformersObjectsToMessagesBusiness(List<ObjectError> objectErrorList){
        List<String> lista = new ArrayList<>();
        objectErrorList.forEach(error -> lista.add(error.getDefaultMessage()));
        return lista;
    }
}
