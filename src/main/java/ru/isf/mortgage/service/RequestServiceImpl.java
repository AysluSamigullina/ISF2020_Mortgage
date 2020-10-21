package ru.isf.mortgage.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.isf.mortgage.entity.Request;
import ru.isf.mortgage.entity.Status;
import ru.isf.mortgage.repo.RequestDao;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Scope("prototype")
public class RequestServiceImpl implements RequestService {
    private RequestDao requestDao;

    public RequestServiceImpl(RequestDao requestDao) {
    }

    @Override
    public void addRequest(Request request) {
        requestDao.add(request);
    }

    /**
     * примитивная проверка заявки на заявленную сумму, чтобы одобрить заявку или отказать
     * @param request
     * @return
     */
    @Override
    public boolean checkRequest(Request request) {
        if (request.getStatus().equals(Status.ON_WORK)) {
            if (request.getSum().compareTo(BigDecimal.valueOf(10000000L)) < 0) {
                updateRequest(request, true);
                return true;
            } else {
                updateRequest(request, false);
                return false;
            }
        } else
            return false;
    }

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

    @Override
    public Request readRequest(UUID id) {
        return requestDao.get(id);
    }

    @Override
    public void deleteRequest(Request request) {
        requestDao.delete(request);
    }

    @Override
    public List<Request> showRequests() {
        return requestDao.show();
    }
}
