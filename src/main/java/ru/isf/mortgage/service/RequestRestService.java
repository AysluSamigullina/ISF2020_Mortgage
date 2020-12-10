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
     * @param requestDto новая заявка
     * @return RequestDto созданная заявка с заполненным полем id
     */
    RequestDto addRequest(RequestDto requestDto);

    /**
     * Вывод списка заявок
     * @return List<Request> список заявок
     */
    List<Request> showRequests();

    /**
     * Получение заявки по ее id
     * @param id идентификатор заявки
     * @return RequestDto модель заявки, найденная по ее id
     */
    RequestDto getRequest(UUID id);

    /**
     * Удаление заявки из списка заявок
     * @param id идентификатор заяаки
     */
    void deleteRequest(UUID id);

    /**
     * Обновление заявки
     * @param dto заявка с новыми полями для изменения
     * @return RequestDto заявка с обновленными полями
     */
    RequestDto updateRequest(RequestDto dto);

}
