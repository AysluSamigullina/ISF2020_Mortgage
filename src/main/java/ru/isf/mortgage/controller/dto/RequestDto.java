package ru.isf.mortgage.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
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
     * Дата отправки заявки
     */
    private LocalDate date;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RequestDto(UUID id, LocalDate date, BigDecimal sum, int term, UUID clientId, String clientFullName) {
        this.id = id;
        this.date = date;
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

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
}
