package ru.isf.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.isf.mortgage.entity.Request;
import ru.isf.mortgage.entity.Status;
import ru.isf.mortgage.repo.RequestDao;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@PropertySource(value = {"classpath:application.properties"})
public class RequestServiceImpl implements RequestService {

    private RequestDao requestDao;

    @Value("${request.maxTerm}")
    private String maxTerm;

    public RequestServiceImpl(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    /**
     * Добавляет заявку в список
     * @param request
     */
    @Override
    public void addRequest(Request request) {
        requestDao.add(request);
    }

    /**
     * примитивная проверка заявки на запрошенный срок, чтобы одобрить заявку или отказать
     * @param request
     * @return
     */
    @Override
    public boolean checkRequest(Request request) {
        if (request.getStatus().equals(Status.ON_WORK)) {
            if (request.getTerm() < Integer.valueOf(maxTerm)) {
                updateRequest(request, true);
                return true;
            } else {
                updateRequest(request, false);
                return false;
            }
        } else
            return false;
    }

    /**
     * Первое обновление заявки до статуса "В работе"
     * @param request
     */
    @Override
    public void updateRequest(Request request) {
        requestDao.update(request);
    }

    /**
     * В случае, когда up = true - заявка обновляется до статуса Одобрена, когда false - отказ
     * @param request
     * @param bool
     */
    private void updateRequest(Request request, boolean bool) {
        requestDao.checkAndUpdate(request, bool);
    }

    /**
     * Возврашает заявку по id
     * @param id
     * @return
     */
    @Override
    public Request readRequest(UUID id) {
        return requestDao.get(id);
    }

    /**
     * Удаляет заявку из списка
     * @param id
     */
    @Override
    public void deleteRequest(UUID id) {
        requestDao.delete(id);
    }

    /**
     * Выводит список заявок
     * @return
     */
    @Override
    public List<Request> showRequests() {
        return requestDao.show();
    }

    @Autowired
    @Lazy
    public void setRequestDao(RequestDao requestDao) {
        this.requestDao = requestDao;
    }
}
