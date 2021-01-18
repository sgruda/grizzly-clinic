package grizzly.software.recruitment.task.vetclinic.repositories;

import grizzly.software.recruitment.task.vetclinic.model.Doctor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

//Class to simulating connection to database.
@Repository
public class DoctorRepository {
    private List<Doctor> doctorList = new LinkedList<>();

    @PostConstruct
    public void init() {
        Doctor[] temp = {
                new Doctor("John Dolittle"),
                new Doctor("Kazimierz Nowak"),
                new Doctor("811a17e2-5988-11eb-ae93-0242ac130002", "Testowy Doktorek")
        };
        doctorList = Arrays.asList(temp);
    }

    public Optional<Doctor> findByUUID(String uuid) {
        return doctorList
                .stream()
                .filter(d -> d.getUuid().equals(uuid))
                .findFirst();
    }
}
