package ru.isf.mortgage.controller.dto;

import java.util.UUID;

/**
 * DTO клиента, подающего заявку
 */
public class ClientDto {
    /**
     * id клиента
     */
    private UUID id;
    /**
     * полное фио клиента
     */
    private String fullName;

    public ClientDto() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
