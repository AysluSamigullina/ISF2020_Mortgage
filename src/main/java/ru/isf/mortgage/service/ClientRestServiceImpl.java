package ru.isf.mortgage.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.isf.mortgage.controller.dto.ClientSearchDto;
import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.repo.ClientDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.LockSupport;

/**
 * Реализация сервиса по работе с клиентом
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
     * @return ClientDto модель - новая заявка
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
     * @return List<ClientDto> список клиентов
     */
    @Override
    public List<ClientDto> showClients() {
        List<Client> clients = clientDao.show();
        List<ClientDto> clientDtoList = new ArrayList<>();
        clients.stream().forEach(client -> clientDtoList.add(new ClientDto(client.getId(), client.getFullName())));
        return clientDtoList;
    }

    /**
     * Вывод клиента по его id
     * @param uuid идентификатор клиента
     * @return ClientDto модель клиента, найденная по указанному id
     */
    @Override
    public ClientDto getClientById(UUID uuid) {
        Client client = clientDao.getClientById(uuid);
        return new ClientDto(client.getId(), client.getFullName());
    }

    /**
     * Удаление клиента по его id
     * @param uuid идентификатор клиента
     */
    @Override
    public void deleteClient(UUID uuid) {
        logger.debug("delete client");
        Client client = clientDao.getClientById(uuid);
        clientDao.delete(client);
    }

    /**
     * Получение клиента по его имени или всего списка клиентов
     * @param clientDto модель для поиска клиента
     * @return List<ClientDto> список клиентов
     */
    @Override
    public List<ClientDto> getClientByNameOrAllClients(ClientSearchDto clientDto) {
        if (clientDto.getName() == null) {
            return showClients();
        } else {
            List<ClientDto> list = new ArrayList<>();
            list.add(getClientByName(clientDto.getName()));
            return list;
        }
    }

    /**
     * Обновление клиента новыми данными
     * @param clientDto существующий клиент с измененными полями
     * @return ClientDto клиент с обновленными полями
     */
    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        logger.debug("update client");
        Client client = clientDao.getClientById(clientDto.getId());
        client.setFullName(clientDto.getFullName());
        clientDao.updateClient(client);
        return clientDto;
    }

    /**
     * Вывод клиента по его имени
     * @param name имя клиента
     * @return ClientDto модель клиента, найденная по указанному имени
     */
    @Override
    public ClientDto getClientByName(String name) {
        Client client = clientDao.getClientByFullName(name);
        return new ClientDto(client.getId(), client.getFullName());
    }
}
