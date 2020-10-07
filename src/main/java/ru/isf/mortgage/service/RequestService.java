package ru.isf.mortgage.service;

import ru.isf.mortgage.entity.Request;

import java.util.UUID;

public interface RequestService {
    void addRequest(Request request);
    void updateRequest(Request request);
    Request readRequest(UUID id);
    void  deleteRequest(Request request);
    void showRequests();
}
