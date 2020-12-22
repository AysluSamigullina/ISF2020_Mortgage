package ru.isf.mortgage.service;

import ru.isf.mortgage.controller.dto.ClientSearchDto;
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
     * @return ClientDto созданная модель dto клиента
     */
    ClientDto addClient(ClientDto clientDto);

    /**
     * Вывод списка клиентов
     * @return List<ClientDto>  список клиентов
     */
    List<ClientDto> showClients();

    /**
     * Вывод клиента по его id
     * @param uuid идентификатор клиента
     * @return ClientDto модель с заполненными полями
     */
    ClientDto getClientById(UUID uuid);

    /**
     * Вывод клиента по его имени
     * @param name имя клиента
     * @return ClientDto модель с указанным именем
     */
    ClientDto getClientByName(String name);

    /**
     * Обновление клиента новыми данными
     * @param clientDto существующий клиент с измененными полями
     * @return ClientDto модел с обновленными значениями
     */
    ClientDto updateClient(ClientDto clientDto);

    /**
     * Удаление клиента по его id
     * @param uuid идентификатор заявки
     */
    void deleteClient(UUID uuid);

    List<ClientDto> getClientByNameOrAllClients(ClientSearchDto clientDto);
}
