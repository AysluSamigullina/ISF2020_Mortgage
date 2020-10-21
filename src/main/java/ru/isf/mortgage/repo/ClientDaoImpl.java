package ru.isf.mortgage.repo;

import org.springframework.stereotype.Repository;
import ru.isf.mortgage.entity.Client;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {
    private List<Client> clientList = new ArrayList<>();

//    public ClientDaoImpl() {
//        super();
//    }

    @Override
    public void add(Client client) {
        clientList.add(client);
    }

    @Override
    public void delete(Client client) {
        clientList.remove(client);
    }

    @Override
    public List<Client> show() {
        return clientList;
    }
}
