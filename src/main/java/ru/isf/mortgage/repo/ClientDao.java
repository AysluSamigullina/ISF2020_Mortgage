package ru.isf.mortgage.repo;

import ru.isf.mortgage.entity.Client;

import java.util.List;

/**
 * ДАО для работы с сущностью Client.
 * Существуют методы для добавления клиента, удаления клиента и вывода списка клиентов
 */
public interface ClientDao {
    /**
     * Добавляет клиента в список
     * @param client
     */
    void add(Client client);

    /**
     * Удаляет клиента из списка
     * @param client
     */
    void delete(Client client);

    /**
     * Выводит список клиентов
     * @return
     */
    List<Client> show();

    /**
     * Возвращает клиента по полному фио
     * @param fullname
     * @return
     */
    Client getClient(String fullname);
}
