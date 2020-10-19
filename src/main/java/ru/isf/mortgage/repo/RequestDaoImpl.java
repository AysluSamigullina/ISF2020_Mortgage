package ru.isf.mortgage.repo;

import ru.isf.mortgage.entity.Request;
import ru.isf.mortgage.entity.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RequestDaoImpl implements RequestDao{
    private List<Request> requestList = new ArrayList<>();

    @Override
    public void add(Request request) {
        requestList.add(request);
    }

    @Override
    public void checkAndUpdate(Request request, boolean bool) {
        if (bool) {
            request.setStatus(Status.APPROVED);
        } else {
            request.setStatus(Status.REFUSED);
        }
    }

    @Override
    public void update(Request request) {
        if (request.getStatus().equals(Status.NEW)) {
            request.setStatus(Status.ON_WORK);
        }
    }

    @Override
    public Request get(UUID id) {
        return requestList.stream().filter(req -> id.equals(req.getId())).findAny().orElse(null);
    }

    @Override
    public void delete(Request request) {
        requestList.remove(request);
    }

    @Override
    public List<Request> show() {
        return requestList;
        //requestList.stream().forEach(s -> System.out.println(s));
    }
}
