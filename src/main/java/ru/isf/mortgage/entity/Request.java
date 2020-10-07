package ru.isf.mortgage.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Request {
    private UUID id;
    private LocalDate date;
    private BigDecimal sum;
    private int term;
    private Client client;
    private Status status;

    public Request() {
        this.id = UUID.randomUUID();
        this.status = Status.NEW;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request id = " + id + ", date = " + date + ", sum = " + sum + ", term = " + term + "months" + ", Client = " + client.getFullName() + ", status = " + status;
    }
}
