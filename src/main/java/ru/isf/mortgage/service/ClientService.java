package ru.isf.mortgage.service;

import ru.isf.mortgage.entity.Client;

public interface ClientService {
    void addClient(Client client);
    void showClients();
}
