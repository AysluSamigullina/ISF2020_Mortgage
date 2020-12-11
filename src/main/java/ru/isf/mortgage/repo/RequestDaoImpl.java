package ru.isf.mortgage.repo;

import org.springframework.stereotype.Repository;
import ru.isf.mortgage.controller.dto.RequestDto;
import ru.isf.mortgage.entity.Request;
import ru.isf.mortgage.entity.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class RequestDaoImpl implements RequestDao {
    private List<Request> requestList = new ArrayList<>();

    /**
     * Добавляет заявку
     * * получения заявки по id,
     *
     * @param request
     */
    @Override
    public void add(Request request) {
        requestList.add(request);
    }

    /**
     * Проверяет и обновляет статус статус заявки до добрения и отказа
     *
     * @param request
     * @param bool
     */
    @Override
    public void checkAndUpdate(Request request, boolean bool) {
        if (bool) {
            request.setStatus(Status.APPROVED);
        } else {
            request.setStatus(Status.REFUSED);
        }
    }

    @Override
    public void updateNew(Request request) {
        Request old = get(request.getId());
        delete(request.getId());
        add(request);
    }

    /**
     * Обновляет заявку
     *
     * @param request
     */
    @Override
    public void update(Request request) {
        if (request.getStatus().equals(Status.NEW)) {
            request.setStatus(Status.ON_WORK);
        }
    }

    /**
     * Возвращает заявку по id
     *
     * @param id
     * @return
     */
    @Override
    public Request get(UUID id) {
        Optional<Request> request = requestList.stream().filter(req -> id.equals(req.getId())).findAny();
        return request.get();
    }

    /**
     * Удаляет заявку из списка
     *
     * @param id
     */
    @Override
    public void delete(UUID id) {
        requestList.remove(get(id));
    }

    /**
     * Выводит заявки
     *
     * @return
     */
    @Override
    public List<Request> show() {
        return requestList;
    }
}
