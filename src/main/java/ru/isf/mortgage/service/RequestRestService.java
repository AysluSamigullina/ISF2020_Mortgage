package ru.isf.mortgage.service;

import ru.isf.mortgage.controller.dto.RequestDto;
import ru.isf.mortgage.entity.Request;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс сервиса для обслуживания заявок
 */
public interface RequestRestService {
    /**
     * Добавление заявки в список заявок
     * @param requestDto
     * @return
     */
    RequestDto addRequest(RequestDto requestDto);

    /**
     * Вывод списка заявок
     * @return
     */
    List<Request> showRequests();

    /**
     * Получение заявки по ее id
     * @param id
     * @return
     */
    RequestDto getRequest(UUID id);

    /**
     * Получение статуса заявки по ее id
     * @param id
     * @return
     */
    String getRequestStatus(UUID id);

    /**
     * Удаление заявки из списка заявок
     * @param id
     */
    void deleteRequest(UUID id);

    /**
     * Обновление заявки со статусом "новый" на статус "в работе"
     * @param uuid
     * @return
     */
    RequestDto updateRequest(UUID uuid);

    /**
     * Проверяет параметры заявки
     * @param uuid
     * @return
     */
    RequestDto checkRequest(UUID uuid);
}
