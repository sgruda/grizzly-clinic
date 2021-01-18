package grizzly.software.recruitment.task.vetclinic.repositories;

import grizzly.software.recruitment.task.vetclinic.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//Class to simulating connection to database.
@Repository
public class AppointmentRepository {
    private Map<String, Appointment> appointmentMap = new HashMap<>();

    public void add(Appointment toAdd) {
        appointmentMap.put(toAdd.getUuid(), toAdd);
    }

    public void cancel(Appointment toCancel) {
        appointmentMap.remove(toCancel.getUuid());
    }

    public Optional<Appointment> findByUUID(String uuid) {
        return Optional.ofNullable(appointmentMap.get(uuid));
    }

}
