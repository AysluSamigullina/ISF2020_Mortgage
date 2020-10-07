package ru.isf.mortgage.repo;

import ru.isf.mortgage.entity.Request;

import java.util.ArrayList;
import java.util.List;

public class RequestDaoImpl implements RequestDao{
    private List<Request> requestList = new ArrayList<>();

    @Override
    public void add(Request request) {
        requestList.add(request);
    }

    @Override
    public void update(Request request) {

    }

    @Override
    public Request get(Request request) {
        return null;
    }

    @Override
    public void delete(Request request) {
        requestList.remove(request);
    }

    @Override
    public void show() {
        requestList.stream().forEach(s -> System.out.println(s));
    }
}
