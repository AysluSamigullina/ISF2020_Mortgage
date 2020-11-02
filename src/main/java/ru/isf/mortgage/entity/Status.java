package ru.isf.mortgage.entity;

/**
 * Статус заявки
 */
public enum Status {
    /**
     * новый
     */
    NEW,
    /**
     * в работе
     */
    ON_WORK,
    /**
     * одобрен
     */
    APPROVED,
    /**
     * отклонен
     */
    REFUSED;
}
