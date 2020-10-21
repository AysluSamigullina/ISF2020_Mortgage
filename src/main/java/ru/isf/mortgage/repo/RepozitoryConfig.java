package ru.isf.mortgage.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration
public class RepozitoryConfig {

    @Bean
    @Primary
    public ClientDao getClientDao() {
        return new ClientDaoImpl();
    }

    @Bean
    public RequestDao getRequestDao() {
        return new RequestDaoImpl();
    }
}
