package ru.isf.mortgage.controller.dto;

import ru.isf.mortgage.entity.Status;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO для заявки
 */
public class RequestDto {
    /**
     * id заявки
     */
    private UUID id;
    /**
     * Сумма заявки
     */
    private BigDecimal sum;
    /**
     * Длительность ипотеки в месяцах
     */
    private int term;
    /**
     * id клиента, подаюшего заявку
     */
    private UUID clientId;
    /**
     * фио клиента, подающего заявку
     */
    private String clientFullName;
    /**
     * статус заявки
     */
    private String status;

    public RequestDto() {}

    public RequestDto(UUID id, BigDecimal sum, int term, UUID clientId, String clientFullName, Status status) {
        this.id = id;
        this.sum = sum;
        this.term = term;
        this.clientId = clientId;
        this.clientFullName = clientFullName;
        this.status = status.toString();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RequestDto(UUID id, BigDecimal sum, int term, UUID clientId, String clientFullName) {
        this.id = id;
        this.sum = sum;
        this.term = term;
        this.clientId = clientId;
        this.clientFullName = clientFullName;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
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

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
}
