package grizzly.software.recruitment.task.vetclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {
    private String uuid;
    private String name;
    private String id;
    private String pin;
    @JsonBackReference
    private List<Appointment> appointmentList = new ArrayList<>();

    public Customer(String name, String id, String pin) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.id = id;
        this.pin = pin;
    }

    public Customer(String uuid, String name, String id, String pin) {
        this.uuid = uuid;
        this.name = name;
        this.id = id;
        this.pin = pin;
    }

    public String getUuid() {
        return uuid;
    }

    public String getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointmentList.remove(appointment);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + pin.hashCode();
        return result;
    }
}
