package ru.isf.mortgage.repo;

import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.entity.Client;

import java.util.List;
import java.util.UUID;

/**
 * ДАО для работы с сущностью Client.
 * Существуют методы для добавления клиента, удаления клиента и вывода списка клиентов
 */
public interface ClientDao {
    /**
     * Добавляет клиента в список
     * @param client
     */
    Client add(Client client);

    /**
     * Удаляет клиента из списка
     * @param uuid
     */
    void delete(UUID uuid);

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
    Client getClientByFullName(String fullname);

    /**
     * Возвращает клиента по id
     * @param uuid
     * @return
     */
    Client getClientById(UUID uuid);

    /**
     * Обновляет данные клиента
     * @param client
     */
    void updateClient(Client client);
}
