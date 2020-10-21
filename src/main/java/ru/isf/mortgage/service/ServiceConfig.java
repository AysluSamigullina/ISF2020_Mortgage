package ru.isf.mortgage.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.isf.mortgage.repo.ClientDao;
import ru.isf.mortgage.repo.RequestDao;

@Configuration
public class ServiceConfig {

    @Bean
    public ClientServiceImpl clientServiceImpl(ClientDao clientDao) {
        return new ClientServiceImpl(clientDao);
    }

    @Bean
    public RequestService requestServiceImpl(RequestDao requestDao) {
        return new RequestServiceImpl(requestDao);
    }
}
