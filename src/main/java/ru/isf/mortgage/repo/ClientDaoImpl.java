package ru.isf.mortgage.repo;

import ru.isf.mortgage.entity.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    private List<Client> clientList = new ArrayList<>();
    @Override
    public void add(Client client) {
        clientList.add(client);
    }

    @Override
    public void delete(Client client) {
        clientList.remove(client);
    }

    @Override
    public void show() {
        clientList.stream().forEach(s -> System.out.println(s));
    }
}
