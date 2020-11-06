package ru.isf.mortgage.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.service.ClientRegistrationService;

import java.util.List;

/**
 * Рест контроллер для работы с клиентом
 */
@RestController
@RequestMapping("/api/client")
public class ClientController {
    private static final Logger logger = LogManager.getLogger(ClientController.class.getName());

    private ClientRegistrationService clientRegistrationService;

    @Autowired
    public ClientController(ClientRegistrationService clientRegistrationService) {
        this.clientRegistrationService = clientRegistrationService ;
    }

    /**
     * Добавление клиента в список клиентов
     * @param clientDto
     * @return
     */
    @PostMapping(value = "/registration")
    public ClientDto userRegistration(@RequestBody ClientDto clientDto) {
        clientRegistrationService.regClient(clientDto);
        return clientDto;
    }

    /**
     * Вывод списка клиентов
     * @return
     */
    @GetMapping(value = "/show")
    public List<Client> showClients() {
        return clientRegistrationService.showClients();
    }
}
