package grizzly.software.recruitment.task.vetclinic.services.interfaces;

import grizzly.software.recruitment.task.vetclinic.exceptions.BadCredentialsException;
import grizzly.software.recruitment.task.vetclinic.exceptions.CustomerNotExistsException;
import grizzly.software.recruitment.task.vetclinic.exceptions.DoctorNotExistsException;
import grizzly.software.recruitment.task.vetclinic.model.Customer;
import grizzly.software.recruitment.task.vetclinic.model.Doctor;

import java.time.LocalDateTime;

public interface AddAppointmentService {
    Customer getCustomer(String customerUUID) throws CustomerNotExistsException;
    Doctor getDoctor(String doctorUUID) throws DoctorNotExistsException;
    void checkCredentials(String id, String pin, Customer customer) throws BadCredentialsException;
    void addAppointment(Customer customer, Doctor doctor, LocalDateTime localDateTime);
}
