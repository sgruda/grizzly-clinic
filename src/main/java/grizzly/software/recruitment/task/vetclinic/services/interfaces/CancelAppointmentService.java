package grizzly.software.recruitment.task.vetclinic.services.interfaces;

import grizzly.software.recruitment.task.vetclinic.exceptions.AppointmentNotExistsException;
import grizzly.software.recruitment.task.vetclinic.exceptions.BadCredentialsException;
import grizzly.software.recruitment.task.vetclinic.exceptions.CustomerNotExistsException;
import grizzly.software.recruitment.task.vetclinic.exceptions.UnauthorizedAttemptOfAccessToAppointmentException;
import grizzly.software.recruitment.task.vetclinic.model.Customer;


public interface CancelAppointmentService {
    Customer getCustomer(String customerUUID) throws CustomerNotExistsException;
    void checkCredentials(String id, String pin, Customer customer) throws BadCredentialsException;
    void cancelAppointment(String appointmentUUUID, String ownerUUID) throws AppointmentNotExistsException, UnauthorizedAttemptOfAccessToAppointmentException;
}
