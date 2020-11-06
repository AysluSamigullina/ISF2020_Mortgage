package ru.isf.mortgage.service;

import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.entity.Client;

import java.util.List;

/**
 * Сервис для работы с клиентов
 */
public interface ClientRegistrationService {
    /**
     * Добавление клиента в список клиентов
     * @param clientDto
     * @return
     */
    ClientDto regClient(ClientDto clientDto);

    /**
     * Вывод списка клиентов
     * @return
     */
    List<Client> showClients();
}
