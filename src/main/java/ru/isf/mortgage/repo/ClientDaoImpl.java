package ru.isf.mortgage.repo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.service.ClientRestServiceImpl;

import java.util.*;

/**
 * Реализация интерфейса ClientDao
 */
@Repository
public class ClientDaoImpl implements ClientDao {

    private static final Logger logger = LogManager.getLogger(ClientDaoImpl.class.getName());

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    private SimpleJdbcCall simpleJdbcCall;

    public ClientDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate, SimpleJdbcInsert simpleJdbcInsert, SimpleJdbcCall simpleJdbcCall) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        this.simpleJdbcCall = simpleJdbcCall;
        simpleJdbcInsert.withTableName("client");
    }

    /**
     * Добавляет клиента в список
     * @param client
     */
    @Override
    public Client add(Client client) {
        client.setId(UUID.randomUUID());
        int result = addClientUsingSimpleJdbcInsert(client);
        logger.info("add " + result);
        return client;
    }

    private int addClientUsingSimpleJdbcInsert(final Client client) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", client.getId());
        parameters.put("fullName", client.getFullName());
        return simpleJdbcInsert.execute(parameters);
    }

    /**
     * Удаляет клиента из списка
     * @param uuid
     */
    @Override
    public void delete(UUID uuid) {
        jdbcTemplate.update("DELETE FROM client WHERE id = ?", uuid);
    }

    /**
     * Возвращает список клиентов
     * @return
     */
    @Override
    public List<Client> show() {
        return jdbcTemplate.query("SELECT * FROM client", new ClientRowMapper());
    }

    /**
     * Обновляет данные клиента
     * @param client
     */
    @Override
    public void updateClient(Client client) {
        jdbcTemplate.update("update client set fullname = ? WHERE id = ?", client.getFullName(), client.getId());
    }

    /**
     * Возвращает клиента по его id
     * @param uuid
     * @return
     */
    @Override
    public Client getClientById(UUID uuid) {
        return jdbcTemplate.queryForObject("SELECT * FROM client WHERE id = ?", new Object[]{uuid}, new ClientRowMapper());
    }

    /**
     * Возвращает клиента по полному фио
     * @param fullname
     * @return
     */
    @Override
    public Client getClientByFullName(String fullname) {
        return getClientUsingMapSqlParameterSource(fullname);

    }

    private Client getClientUsingMapSqlParameterSource(String fullname) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("fullName", fullname);

        return namedParameterJdbcTemplate
                .queryForObject("SELECT * FROM client WHERE fullName = :fullName", namedParameters, new ClientRowMapper());
    }
}
