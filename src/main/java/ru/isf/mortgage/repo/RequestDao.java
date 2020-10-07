package ru.isf.mortgage.repo;

import ru.isf.mortgage.entity.Request;

public interface RequestDao {
    void add(Request request);
    void update(Request request);
    Request get(Request request);
    void delete(Request request);
    void show();
}
