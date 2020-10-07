package ru.isf.mortgage.service;

import ru.isf.mortgage.entity.Request;
import ru.isf.mortgage.repo.RequestDao;

import java.util.UUID;

public class RequestServiceImpl implements RequestService {
    private RequestDao requestDao;

    public RequestServiceImpl(RequestDao requestDao) {
        this.requestDao = requestDao;
    }
    @Override
    public void addRequest(Request request) {
        requestDao.add(request);
    }

    @Override
    public void updateRequest(Request request) {

    }

    @Override
    public Request readRequest(UUID id) {
        return null;
    }

    @Override
    public void deleteRequest(Request request) {

    }

    @Override
    public void showRequests() {
        requestDao.show();
    }
}
