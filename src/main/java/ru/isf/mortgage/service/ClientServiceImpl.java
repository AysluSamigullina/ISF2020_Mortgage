package ru.isf.mortgage.service;

import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.repo.ClientDao;

import java.util.List;

public class ClientServiceImpl implements ClientService{

    private ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
    @Override
    public void addClient(Client client) {
        clientDao.add(client);
    }

    @Override
    public List<Client> showClients() {
        return clientDao.show();
    }

}
