package ru.isf.mortgage.entity;

import java.util.UUID;

/** Client
 *
 */
public class Client {
    private UUID id;
    private String fullName;

    public Client() {
        this.id = UUID.randomUUID();
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
