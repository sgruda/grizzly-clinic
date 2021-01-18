package grizzly.software.recruitment.task.vetclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Doctor {
    private String uuid;
    private String name;
    @JsonBackReference
    private List<Appointment> appointmentList = new ArrayList<>();

    public Doctor(String name) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
    }

    public Doctor(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
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
        return result;
    }
}
