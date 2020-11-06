package ru.isf.mortgage.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.repo.ClientDao;

import java.util.List;

/**
 * Реализауия сервиса по работе с клиентом
 */
@Service
public class ClientRegistrationServiceImpl implements ClientRegistrationService {

    private static final Logger logger = LogManager.getLogger(ClientRegistrationServiceImpl.class.getName());
    private ClientDao clientDao;

    public ClientRegistrationServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    /**
     * Добавление клиента в список клиентов
     * @param clientDto
     * @return
     */
    @Override
    public ClientDto regClient(ClientDto clientDto) {
        Client client = new Client(clientDto.getFullName());
        clientDao.add(client);
        clientDto.setId(client.getId());
        return clientDto;
    }

    /**
     * Вывод списка клиентов
     * @return
     */
    @Override
    public List<Client> showClients() {
        return clientDao.show();
    }
}
