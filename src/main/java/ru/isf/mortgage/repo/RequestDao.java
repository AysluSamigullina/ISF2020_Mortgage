package ru.isf.mortgage.repo;

import ru.isf.mortgage.entity.Request;

import java.util.List;
import java.util.UUID;

public interface RequestDao {
    void add(Request request);
    void update(Request request);
    void checkAndUpdate(Request request, boolean bool);
    Request get(UUID id);
    void delete(Request request);
    List<Request> show();
}
