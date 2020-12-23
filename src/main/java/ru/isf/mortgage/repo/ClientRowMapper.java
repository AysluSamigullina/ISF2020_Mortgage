package ru.isf.mortgage.repo;

import org.springframework.jdbc.core.RowMapper;
import ru.isf.mortgage.entity.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Client client = new Client();
        client.setId(UUID.fromString(rs.getString("id")));
        client.setFullName(rs.getString("fullName"));
        return client;
    }
}
