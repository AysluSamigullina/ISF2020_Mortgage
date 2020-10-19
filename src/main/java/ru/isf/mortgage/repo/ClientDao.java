package ru.isf.mortgage.repo;

import ru.isf.mortgage.entity.Client;

import java.util.List;


public interface ClientDao {
    void add(Client client);
    void delete(Client client);
    List<Client> show();
}
