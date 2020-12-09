package ru.isf.mortgage.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.isf.mortgage.controller.dto.RequestDto;
import ru.isf.mortgage.entity.Client;
import ru.isf.mortgage.entity.Request;
import ru.isf.mortgage.entity.Status;
import ru.isf.mortgage.repo.ClientDao;
import ru.isf.mortgage.repo.RequestDao;

import java.util.List;
import java.util.UUID;

/**
 * Реализация работы с заявками
 */
@Service
public class RequestRestServiceImpl implements RequestRestService {
    private static final Logger logger = LogManager.getLogger(RequestRestServiceImpl.class.getName());
    private RequestDao requestDao;
    private ClientDao clientDao;

    @Value("${request.maxTerm}")
    private String maxTerm;

    public RequestRestServiceImpl(RequestDao requestDao, ClientDao clientDao) {
        this.requestDao = requestDao;
        this.clientDao = clientDao;
    }

    /**
     * Добавление заявки в список заявок
     * Если существует клиент с таким ФИО, то новый клиент от заявки не создается.
     * Если не существует такого клиента, то создается новая заявка и новый клиент
     *
     * @param requestDto
     * @return
     */
    @Override
    public RequestDto addRequest(RequestDto requestDto) {
        logger.debug("add request");
        Request request = new Request(requestDto.getSum(), requestDto.getTerm());
        Client client = clientDao.getClientByFullName(requestDto.getClientFullName());
        if (client == null) {
            client = new Client(requestDto.getClientFullName());
            clientDao.add(client);
        }
        request.setClient(client);
        requestDao.add(request);
        requestDto.setId(request.getId());
        requestDto.setClientId(client.getId());
        requestDto.setStatus(request.getStatus().toString());
        return requestDto;
    }

    @Override
    public RequestDto updateRequest(RequestDto requestDto) {
        logger.debug("update request");
        Request req = requestDao.get(requestDto.getId());
        req.setSum(requestDto.getSum());
        req.setTerm(requestDto.getTerm());
        req.setStatus(Status.valueOf(requestDto.getStatus()));
        requestDao.updateNew(req);
        return requestDto;
    }

    /**
     * Вывод списка заявок
     *
     * @return
     */
    @Override
    public List<Request> showRequests() {
        return requestDao.show();
    }

    /**
     * Получение заявки по ее id
     *
     * @param id
     * @return
     */
    @Override
    public RequestDto getRequest(UUID id) {
        Request req = requestDao.get(id);
        return new RequestDto(req.getId(), req.getSum(), req.getTerm(), req.getClient().getId(), req.getClient().getFullName(), req.getStatus());
    }

    /**
     * Удаление заявки из списка заявок
     *
     * @param id
     */
    @Override
    public void deleteRequest(UUID id) {
        logger.debug("delete request");
        requestDao.delete(id);
    }
}
