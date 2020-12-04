package ru.isf.mortgage.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.service.ClientRegistrationService;

import java.net.URI;
import java.util.List;

/**
 * Рест контроллер для работы с клиентом
 */
@RestController
@RequestMapping("/api/client")
public class ClientController {
    private static final Logger logger = LogManager.getLogger(ClientController.class.getName());

    private ClientRegistrationService clientRegistrationService;

    public ClientController(ClientRegistrationService clientRegistrationService) {
        this.clientRegistrationService = clientRegistrationService ;
    }

    /**
     * Добавление клиента в список клиентов
     * @param clientDto
     * @return
     */
    @PostMapping(value = "/registration")
    public ResponseEntity<ClientDto> userRegistration(@RequestBody ClientDto clientDto, UriComponentsBuilder componentsBuilder) {
        ClientDto client = clientRegistrationService.regClient(clientDto);
        URI uri = componentsBuilder.path("/api/client/" + client.getId()).buildAndExpand(client).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    /**
     * Вывод списка клиентов
     * @return
     */
    @GetMapping()
    public List<Client> showClients() {
        return clientRegistrationService.showClients();
    }
}
