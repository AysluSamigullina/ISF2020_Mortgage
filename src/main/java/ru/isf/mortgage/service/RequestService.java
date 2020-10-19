package ru.isf.mortgage.service;

import ru.isf.mortgage.entity.Request;

import java.util.List;
import java.util.UUID;

public interface RequestService {
    void addRequest(Request request);
    void updateRequest(Request request);
    Request readRequest(UUID id);
    void  deleteRequest(Request request);
    boolean checkRequest(Request request);
    List<Request> showRequests();
}
