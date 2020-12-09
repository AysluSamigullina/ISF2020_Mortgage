package ru.isf.mortgage.service;

import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.entity.Client;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с клиентов
 */
public interface ClientRestService {
    /**
     * Добавление клиента в список клиентов
     * @param clientDto
     * @return
     */
    ClientDto addClient(ClientDto clientDto);

    /**
     * Вывод списка клиентов
     * @return
     */
    List<Client> showClients();

    ClientDto getClientById(UUID uuid);

    ClientDto getClientByName(String name);

    ClientDto updateClient(ClientDto clientDto);

    void deleteClient(UUID uuid);
}
