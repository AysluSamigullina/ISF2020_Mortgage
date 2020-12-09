package ru.isf.mortgage.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.isf.mortgage.controller.dto.RequestDto;
import ru.isf.mortgage.entity.Request;
import ru.isf.mortgage.service.RequestRestService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * Рест контроллер для работы с заявками
 */
@RestController
@RequestMapping("/api/request")
public class  RequestController {
    private static final Logger logger = LogManager.getLogger(RequestController.class.getName());

    private RequestRestService requestRestService;

    public RequestController(RequestRestService requestRestService) {
        this.requestRestService = requestRestService ;
    }

    /**
     * Добавление заявки в список заявок
     * @param requestDto
     * @return
     */
    @PostMapping()
    public ResponseEntity<RequestDto>  addRequest(@RequestBody RequestDto requestDto, UriComponentsBuilder componentsBuilder) {
        RequestDto req =  requestRestService.addRequest(requestDto);
        URI uri = componentsBuilder.path("/api/request/" + req.getId()).buildAndExpand(req).toUri();
        return ResponseEntity.created(uri).body(req);
    }

    /**
     * Вывод списка заявок
     * @return
     */
    @GetMapping()
    public List<Request> showRequests() {
        return requestRestService.showRequests();
    }

    /**
     * Вывод заявки по id
     * @param uuid
     * @return
     */
    @GetMapping(value = "/{id}")
    public RequestDto showRequestById(@PathVariable("id") UUID uuid) {
        return requestRestService.getRequest(uuid);
    }

    /**
     * Обновление заявки
     * @param uuid
     * @return
     */
    @PutMapping(value = "/{id}")
    public RequestDto updateRequest(@PathVariable(value = "id") UUID uuid, @RequestBody RequestDto requestDto) {
        if (!uuid.equals(requestDto.getId())) {
            throw new RuntimeException("ids are not equal");
        }
        return requestRestService.updateRequest(requestDto);
    }

    /**
     * Удаление заявки из списка
     * @param uuid
     */
    @DeleteMapping(value = "/{id}")
    public void deleteRequest(@PathVariable(value = "id") UUID uuid) {
        requestRestService.deleteRequest(uuid);
    }
}
