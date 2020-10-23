package ru.isf.mortgage.repo;

import ru.isf.mortgage.entity.Client;

import java.util.List;

/**
 * ДАО для работы с сущностью Client.
 * Существуют методы для добавления клиента, удаления клиента и вывода списка клиентов
 */
public interface ClientDao {
    void add(Client client);
    void delete(Client client);
    List<Client> show();
}
