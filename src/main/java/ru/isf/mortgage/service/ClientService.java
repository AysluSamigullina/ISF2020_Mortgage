package ru.isf.mortgage.service;

import ru.isf.mortgage.entity.Client;
import java.util.List;

/**
 * Сервис для работы с клиентами
 */
public interface ClientService {
    /**
     * Добавляет клиента в список
     * @param client
     */
    void addClient(Client client);

    /**
     * Выводит список клиентов
     * @return
     */
    List<Client> showClients();
}
