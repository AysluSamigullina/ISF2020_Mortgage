package ru.isf.mortgage.controller.dto;

import java.util.UUID;

public class ResponseError {
    private UUID id;
    private String message;
    private String codeError;
    private String systemId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCodeError() {
        return codeError;
    }

    public ResponseError(UUID id, String message, String codeError, String systemId) {
        this.id = id;
        this.message = message;
        this.codeError = codeError;
        this.systemId = systemId;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}
