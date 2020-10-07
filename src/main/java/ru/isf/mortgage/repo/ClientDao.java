package ru.isf.mortgage.repo;

import ru.isf.mortgage.entity.Client;


public interface ClientDao {
    void add(Client client);
    void delete(Client client);
    void show();
}
