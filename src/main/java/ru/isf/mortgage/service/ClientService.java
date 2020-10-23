package ru.isf.mortgage.service;

import ru.isf.mortgage.entity.Client;
import java.util.List;

/**
 * Сервис для работы с клиентами
 */
public interface ClientService {
    void addClient(Client client);
    List<Client> showClients();
}
