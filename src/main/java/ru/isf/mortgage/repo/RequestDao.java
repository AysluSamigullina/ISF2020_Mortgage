package ru.isf.mortgage.repo;

import ru.isf.mortgage.controller.dto.RequestDto;
import ru.isf.mortgage.entity.Request;

import java.util.List;
import java.util.UUID;

/**
 * ДАО для работы с заявками
 */
public interface RequestDao {
    /**
     * Добавляет заявку в список
     * @param request
     */
    void add(Request request);

    /**
     * Обновляет статуса заявки
     * @param request
     */
    void update(Request request);

    void updateNew(Request request);
    /**
     * Проверяет заявки и обновляет статус
     * @param request
     * @param bool
     */
    void checkAndUpdate(Request request, boolean bool);

    /**
     * Находит заявку по id
     * @param id
     * @return
     */
    Request get(UUID id);

    /**
     * Удаляет заявку из списка
     * @param id
     */
    void delete(UUID id);

    /**
     * Выводит список заявок
     * @return
     */
    List<Request> show();
}
