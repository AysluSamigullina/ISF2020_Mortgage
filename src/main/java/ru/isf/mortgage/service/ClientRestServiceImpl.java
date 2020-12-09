package ru.isf.mortgage.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.repo.ClientDao;

import java.util.List;
import java.util.UUID;

/**
 * Реализауия сервиса по работе с клиентом
 */
@Service
public class ClientRestServiceImpl implements ClientRestService {

    private static final Logger logger = LogManager.getLogger(ClientRestServiceImpl.class.getName());
    private ClientDao clientDao;

    public ClientRestServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    /**
     * Добавление клиента в список клиентов
     *
     * @param clientDto
     * @return
     */
    @Override
    public ClientDto addClient(ClientDto clientDto) {
        logger.debug("add client");
        Client client = new Client(clientDto.getFullName());
        clientDao.add(client);
        clientDto.setId(client.getId());
        return clientDto;
    }

    /**
     * Вывод списка клиентов
     *
     * @return
     */
    @Override
    public List<Client> showClients() {
        return clientDao.show();
    }

    @Override
    public ClientDto getClientById(UUID uuid) {
        Client client = clientDao.getClientById(uuid);
        return new ClientDto(client.getId(), client.getFullName());
    }

    @Override
    public void deleteClient(UUID uuid) {
        logger.debug("delete client");
        Client client = clientDao.getClientById(uuid);
        clientDao.delete(client);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        logger.debug("update client");
        Client client = clientDao.getClientById(clientDto.getId());
        client.setFullName(clientDto.getFullName());
        clientDao.updateClient(client);
        return clientDto;
    }

    @Override
    public ClientDto getClientByName(String name) {
        Client client = clientDao.getClientByFullName(name);
        return new ClientDto(client.getId(), client.getFullName());
    }
}
