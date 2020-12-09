package ru.isf.mortgage.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.service.ClientRestService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * Рест контроллер для работы с клиентом
 */
@RestController
@RequestMapping("/api/client")
public class ClientController {
    private static final Logger logger = LogManager.getLogger(ClientController.class.getName());

    private ClientRestService clientRestService;

    public ClientController(ClientRestService clientRestService) {
        this.clientRestService = clientRestService;
    }

    /**
     * Добавление клиента в список клиентов
     * @param clientDto
     * @return
     */
    @PostMapping()
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto clientDto, UriComponentsBuilder componentsBuilder) {
        logger.debug("add new client " + clientDto.getFullName());
        ClientDto client = clientRestService.addClient(clientDto);
        URI uri = componentsBuilder.path("/api/client/" + client.getId()).buildAndExpand(client).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    /**
     * Вывод списка клиентов
     * @return
     */
    @GetMapping()
    public List<Client> showClients() {
        return clientRestService.showClients();
    }

    /**
     * Вывод клиента по его id
     * @param uuid
     * @return
     */
    @GetMapping(value = "id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClientById(@PathVariable("id") UUID uuid) {
        return clientRestService.getClientById(uuid);
    }

    /**
     * Вывод клиента по его имени
     * @param name
     * @return
     */
    @GetMapping(value = "name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClientByName(@PathVariable("name") String name) {
        return clientRestService.getClientByName(name);
    }

    /**
     * Обновление данных клиента
     * @param id
     * @param clientDto
     * @return
     */
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto updateClient(@PathVariable("id") UUID id, @RequestBody ClientDto clientDto) {
        if (!id.equals(clientDto.getId())) {
            throw new RuntimeException("ids are not equal");
        }
        return clientRestService.updateClient(clientDto);
    }

    /**
     * Удаление клиента из списка
     * @param uuid
     */
    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable("id") UUID uuid){
        clientRestService.deleteClient(uuid);
    }
}
