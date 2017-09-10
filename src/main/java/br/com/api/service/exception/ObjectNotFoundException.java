package br.com.api.service.exception;

import java.util.List;

public class ObjectNotFoundException extends RuntimeException {

    private String message;
    private List<ObjectNotFoundException> multipleMessages;

    public ObjectNotFoundException(String message){
        super(message);
        this.message = message;
    }

    public ObjectNotFoundException(List<ObjectNotFoundException> multipleMessages){
        this.multipleMessages = multipleMessages;
    }

    public String getMessage() {
        return message;
    }

    public List<ObjectNotFoundException> getMultipleMessages() {
        return multipleMessages;
    }
}
