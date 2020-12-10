package ru.isf.mortgage.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.isf.mortgage.controller.dto.ClientDto;
import ru.isf.mortgage.controller.dto.ClientSearchDto;
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
     * @param clientDto новый клиент с заполненными полями
     * @return созданный dto с клиентом
     */
    @PostMapping()
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto clientDto, UriComponentsBuilder componentsBuilder) {
        logger.debug("add new client " + clientDto.getFullName());
        ClientDto client = clientRestService.addClient(clientDto);
        URI uri = componentsBuilder.path("/api/client/" + client.getId()).buildAndExpand(client).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    /**
     * Вывод списка клиентов. Если в ClientSearchDto указано имя клиента, то выводится этот клиент.
     * Если body не заполнено, то выводится весь список клиентов
     * @return List<ClientDto> список клиентов
     */
    @GetMapping()
    public List<ClientDto> showClients(@RequestBody ClientSearchDto clientDto) {
        return clientRestService.getClientByNameOrAllClients(clientDto);
    }

    /**
     * Вывод клиента по его id
     * @param uuid идентификатор клиента
     * @return клиент с отправленным id
     */
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClientById(@PathVariable("id") UUID uuid) {
        return clientRestService.getClientById(uuid);
    }


    /**
     * Обновление данных клиента
     * @param id идентификатор клиента
     * @param clientDto dto клиента с новыми значениями
     * @return записанное dto  с новыми значениями
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
     * @param uuid идентификатор клиента
     */
    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable("id") UUID uuid){
        clientRestService.deleteClient(uuid);
    }
}
