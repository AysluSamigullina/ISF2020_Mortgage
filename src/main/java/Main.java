import ru.isf.mortgage.entity.Client;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.isf.mortgage.entity.Request;
import ru.isf.mortgage.service.ClientService;
import ru.isf.mortgage.service.RequestService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        ClientService clientService = (ClientService) context.getBean("clientService");
        RequestService requestService = (RequestService) context.getBean("requestService");

        Client client1 = new Client();
        client1.setFullName("Иванов Иван Иванович");
        Client client2 = new Client();
        client2.setFullName("Петров Петр Петрович");

        clientService.addClient(client1);
        clientService.addClient(client2);

        Request request1 = new Request();
        request1.setClient(client1);
        request1.setDate(LocalDate.now());
        request1.setSum(BigDecimal.valueOf(2000000));
        request1.setTerm(120);

        Request request2 = new Request();
        request2.setClient(client2);
        request2.setDate(LocalDate.now());
        request2.setSum(BigDecimal.valueOf(6000000));
        request2.setTerm(360);

        requestService.addRequest(request1);
        requestService.addRequest(request2);

        requestService.showRequests();
        clientService.showClients();
        context.close();
    }
}
