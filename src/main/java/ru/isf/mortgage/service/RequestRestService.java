package ru.isf.mortgage.service;

import ru.isf.mortgage.controller.dto.RequestDto;
import ru.isf.mortgage.entity.Request;

import java.util.List;
import java.util.UUID;

public interface RequestRestService {
    RequestDto addRequest(RequestDto requestDto);

    List<Request> showRequests();

    RequestDto getRequest(UUID id);

    String getRequestStatus(UUID id);

    void deleteRequest(UUID id);

    RequestDto updateRequest(UUID uuid);
}
