package ru.isf.mortgage.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.isf.mortgage.controller.dto.RequestDto;
import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.entity.Request;
import ru.isf.mortgage.entity.Status;
import ru.isf.mortgage.repo.ClientDao;
import ru.isf.mortgage.repo.RequestDao;
import ru.isf.mortgage.validator.RequestDtoValidator;

import java.util.List;
import java.util.UUID;

/**
 * Реализация работы с заявками
 */
@Service
public class RequestRestServiceImpl implements RequestRestService {
    private static final Logger logger = LogManager.getLogger(ClientRegistrationServiceImpl.class.getName());
    private RequestDao requestDao;
    private ClientDao clientDao;
    private RequestDtoValidator requestDtoValidator;

    public RequestRestServiceImpl(RequestDao requestDao, ClientDao clientDao, RequestDtoValidator requestDtoValidator) {
        this.requestDao = requestDao;
        this.clientDao = clientDao;
        this.requestDtoValidator = requestDtoValidator;
    }

    /**
     * Добавление заявки в список заявок
     * Если существует клиент с таким ФИО, то новый клиент от заявки не создается.
     * Если не существует такого клиента, то создается новая заявка и новый клиент
     * @param requestDto
     * @return
     */
    @Override
    public RequestDto addRequest(RequestDto requestDto) {
        requestDtoValidator.validate(requestDto);
        Request request = new Request(requestDto.getSum(), requestDto.getTerm());
        Client client = clientDao.getClient(requestDto.getClientFullName());
        if (client == null) {
            client = new Client(requestDto.getClientFullName());
            clientDao.add(client);
        }
        request.setClient(client);
        requestDao.add(request);
        requestDto.setId(request.getId());
        requestDto.setClientId(client.getId());
        requestDto.setStatus(request.getStatus().toString());
        requestDto.setDate(request.getDate());
        return requestDto;

    }

    /**
     * Обновление заявки со статусом "новый" на статус "в работе"
     * @param uuid
     * @return
     */
    @Override
    public RequestDto updateRequest(UUID uuid) {
        Request req = requestDao.get(uuid);
        if (req != null && req.getStatus().equals(Status.NEW)) {
            requestDao.update(req);
            RequestDto requestDto = new RequestDto(uuid, req.getDate(), req.getSum(), req.getTerm(), req.getClient().getId(), req.getClient().getFullName());
            requestDto.setStatus(Status.ON_WORK.toString());
            return requestDto;
        }
        return null;
    }

    /**
     * Вывод списка заявок
     * @return
     */
    @Override
    public List<Request> showRequests() {
         return requestDao.show();
    }

    /**
     * Получение заявки по ее id
     * @param id
     * @return
     */
    @Override
    public RequestDto getRequest(UUID id) {
        Request req = requestDao.get(id);
        return new RequestDto(req.getId(), req.getDate(), req.getSum(), req.getTerm(), req.getClient().getId(), req.getClient().getFullName(), req.getStatus());
    }

    /**
     * Получение статуса заявки по ее id
     * @param id
     * @return
     */
    @Override
    public String getRequestStatus(UUID id) {
        return null;
    }

    /**
     * Удаление заявки из списка заявок
     * @param id
     */
    @Override
    public void deleteRequest(UUID id) {
        requestDao.delete(id);
    }
}
