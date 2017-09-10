package br.com.api.handler.domain;

public class ResponseError {

    private int status;
    private String description;
    private String messageException;
    private Long timeMiliseconds;

    public ResponseError(int status, String description, String messageException, Long timeMiliseconds) {
        this.status = status;
        this.description = description;
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
}
