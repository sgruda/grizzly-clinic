package grizzly.software.recruitment.task.vetclinic.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {
    private String uuid;
    private LocalDateTime dateTime;
    @JsonManagedReference
    private Doctor doctor;
    private Customer customer;

    public Appointment(Doctor doctor, Customer customer, LocalDateTime localDateTime) {
        this.uuid = UUID.randomUUID().toString();
        this.dateTime = localDateTime;
        this.doctor = doctor;
        this.customer = customer;
    }

    public String getUuid() {
        return uuid;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (!uuid.equals(that.uuid)) return false;
        if (!dateTime.equals(that.dateTime)) return false;
        if (!doctor.getUuid().equals(that.doctor.getUuid())) return false;
        return customer.getUuid().equals(that.customer.getUuid());
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + dateTime.hashCode();
        result = 31 * result + doctor.hashCode();
        result = 31 * result + customer.hashCode();
        return result;
    }
}
