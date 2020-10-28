package ru.isf.mortgage.repo;

import ru.isf.mortgage.entity.Request;

import java.util.List;
import java.util.UUID;

/**
 * ДАО для работы с заявками
 */
public interface RequestDao {
    /**
     * Добавляет заявки в список
     * @param request
     */
    void add(Request request);

    /**
     * Обновляет статуса заявки
     * @param request
     */
    void update(Request request);

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
     * @param request
     */
    void delete(Request request);

    /**
     * Выводит список заявок
     * @return
     */
    List<Request> show();
}
