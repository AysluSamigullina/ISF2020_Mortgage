package ru.isf.mortgage.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.isf.mortgage.controller.dto.RequestDto;
import ru.isf.mortgage.entity.Request;
import ru.isf.mortgage.service.RequestRestService;

import java.util.List;

/**
 * Рест контроллер для работы с заявками
 */
@RestController
@RequestMapping("/api/request")
public class  RequestController {
    private static final Logger logger = LogManager.getLogger(RequestController.class.getName());

    private RequestRestService requestRestService;

    @Autowired
    public RequestController(RequestRestService requestRestService) {
        this.requestRestService = requestRestService ;
    }

    /**
     * Добавление заявки в список заявок
     * @param requestDto
     * @return
     */
    @PostMapping(value = "/add")
    public RequestDto addRequest(@RequestBody RequestDto requestDto) {
        requestRestService.addRequest(requestDto);
        return requestDto;
    }

    /**
     * Вывод списка заявок
     * @return
     */
    @GetMapping(value = "/show")
    public List<Request> showRequests() {
        return requestRestService.showRequests();
    }

    /**
     * Обновление статуса заявки
     * @param requestDto
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public RequestDto updateRequest(@RequestBody RequestDto requestDto) {
        return requestRestService.updateRequest(requestDto.getId());
    }

    /**
     *
     * @param requestDto
     */
    @DeleteMapping(value = "/delete")
    public void deleteRequest(@RequestBody RequestDto requestDto) {
        requestRestService.deleteRequest(requestDto.getId());
    }
}
