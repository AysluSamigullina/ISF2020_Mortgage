package ru.isf.mortgage.service;

import ru.isf.mortgage.entity.Request;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с заявками
 */
public interface RequestService {
    /**
     * Добавляет заявку в список
     * @param request
     */
    void addRequest(Request request);

    /**
     * Обновляет статус заявки
     * @param request
     */
    void updateRequest(Request request);

    /**
     * Находит заявку по id
     * @param id
     * @return
     */
    Request readRequest(UUID id);

    /**
     * Удаляет заявку из списка
     * @param id
     */
    void  deleteRequest(UUID id);

    /**
     * Проверяет параметры заявки
     * @param request
     * @return
     */
    boolean checkRequest(Request request);

    /**
     * Выводит список заявок
     * @return
     */
    List<Request> showRequests();
}
