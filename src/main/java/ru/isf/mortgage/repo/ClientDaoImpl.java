package ru.isf.mortgage.repo;

import org.springframework.stereotype.Repository;
import ru.isf.mortgage.entity.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Реализация интерфейса ClientDao
 */
@Repository
public class ClientDaoImpl implements ClientDao {
    private List<Client> clientList = new ArrayList<>();

    /**
     * Добавляет клиента в список
     * @param client
     */
    @Override
    public void add(Client client) {
        clientList.add(client);
    }

    /**
     * Удаляет клиента из списка
     * @param client
     */
    @Override
    public void delete(Client client) {
        clientList.remove(client);
    }

    /**
     * Возвращает список клиентов
     * @return
     */
    @Override
    public List<Client> show() {
        return clientList;
    }

    /**
     * Возвращает клиента по полному фио
     * @param fullname
     * @return
     */
    @Override
    public Client getClient(String fullname) {
        for (Client client : clientList) {
            if (client.getFullName().equals(fullname)) {
                return client;
            }
        }
        return null;
    }
}
