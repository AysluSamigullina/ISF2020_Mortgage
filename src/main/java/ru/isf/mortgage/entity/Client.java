package ru.isf.mortgage.entity;

import java.util.UUID;

/**
 * Сущность Client. Он будет подавать заявку на ипотеку
 */
public class Client {
    /**
     * id Клиента
     */
    private UUID id;

    /**
     * ФИО клиента
     */
    private String fullName;

    public Client() {
        this.id = UUID.randomUUID();
    }

    public Client(String fullName) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
    }

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

    @Override
    public String toString() {
        return "Client id = " + id + ", Client fullname = " + fullName;
    }
}
