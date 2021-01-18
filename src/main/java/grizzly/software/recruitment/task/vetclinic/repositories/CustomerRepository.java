package grizzly.software.recruitment.task.vetclinic.repositories;

import grizzly.software.recruitment.task.vetclinic.model.Customer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


//Class to simulating connection to database.
@Repository
public class CustomerRepository {
    private List<Customer> customerList = new LinkedList<>();

    @PostConstruct
    public void init() {
        Customer[] temp = {
                new Customer("Jan Kowalski", "1234", "6789"),
                new Customer("Janusz Nowak", "4321", "9876"),
                new Customer("Eugeniusz Zielinski", "0000", "0000"),
                new Customer("811a17e2-2345-111e-ee44-0242ac130002", "Testowy klient", "1111", "2222")
        };
        customerList = Arrays.asList(temp);
    }

    public Optional<Customer> findByUUID(String uuid) {
        return customerList
                .stream()
                .filter(c -> c.getUuid().equals(uuid))
                .findFirst();
    }
}
