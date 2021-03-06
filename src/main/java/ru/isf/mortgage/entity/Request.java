package ru.isf.mortgage.entity;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Сущность Заявка на ипотеку. Клиент заполняет параметры заявки и отправляет на рассмотрение
 */
public class Request {
    /**
     * id заявки
     */
    private UUID id;

    /**
     * Сумма заявки
     */
    private BigDecimal sum;

    /**
     * Количество месяцев, на которое запрашивается ипотека
     */
    private int term;

    /**
     * Клиент, подающий заявку
     */
    private Client client;

    /**
     * Статус заявки
     */
    private Status status;

    public Request() {
        this.id = UUID.randomUUID();
        this.status = Status.NEW;
    }

    public Request(BigDecimal sum, int term) {
        this.id = UUID.randomUUID();
        this.sum = sum;
        this.term = term;
        this.status = Status.NEW;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
        return "Request id = " + id  + ", sum = " + sum + ", term = " + term + "months" + ", Client = " + client.getFullName() + ", status = " + status;
    }
}
