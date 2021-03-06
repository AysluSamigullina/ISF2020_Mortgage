package ru.isf.mortgage.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.repo.ClientDao;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    private static final Logger log = LogManager.getLogger(ClientServiceImpl.class.getName());

    private ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    /**
     * Добавляет клиента в список
     * @param client
     */
    @Override
    public void addClient(Client client) {
        clientDao.add(client);
    }

    /**
     * Выводит список клиентов
     * @return
     */
    @Override
    public List<Client> showClients() {
        return clientDao.show();
    }

}
