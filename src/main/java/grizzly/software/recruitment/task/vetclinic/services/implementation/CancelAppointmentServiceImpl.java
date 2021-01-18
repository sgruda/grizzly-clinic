package grizzly.software.recruitment.task.vetclinic.services.implementation;

import grizzly.software.recruitment.task.vetclinic.exceptions.AppointmentNotExistsException;
import grizzly.software.recruitment.task.vetclinic.exceptions.BadCredentialsException;
import grizzly.software.recruitment.task.vetclinic.exceptions.CustomerNotExistsException;
import grizzly.software.recruitment.task.vetclinic.model.Appointment;
import grizzly.software.recruitment.task.vetclinic.model.Customer;
import grizzly.software.recruitment.task.vetclinic.repositories.AppointmentRepository;
import grizzly.software.recruitment.task.vetclinic.repositories.CustomerRepository;
import grizzly.software.recruitment.task.vetclinic.repositories.DoctorRepository;
import grizzly.software.recruitment.task.vetclinic.services.interfaces.CancelAppointmentService;
import grizzly.software.recruitment.task.vetclinic.utils.CredentialsChecker;
import org.springframework.stereotype.Service;

@Service
public class CancelAppointmentServiceImpl implements CancelAppointmentService {
    private CustomerRepository customerRepository;
    private DoctorRepository doctorRepository;
    private AppointmentRepository appointmentRepository;

    public CancelAppointmentServiceImpl(CustomerRepository customerRepository, DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
        this.customerRepository = customerRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public Customer getCustomer(String customerUUID) throws CustomerNotExistsException {
        return customerRepository.findByUUID(customerUUID)
                .orElseThrow(() -> new CustomerNotExistsException());
    }

    @Override
    public void checkCredentials(String id, String pin, Customer customer) throws BadCredentialsException {
        CredentialsChecker credentialsChecker = new CredentialsChecker();
        credentialsChecker.checkCredentials(id, pin, customer.getId(), customer.getPin());
    }

    @Override
    public void cancelAppointment(String appointmentUUUID) throws AppointmentNotExistsException {
        Appointment appointment = appointmentRepository.findByUUID(appointmentUUUID)
                .orElseThrow(() -> new AppointmentNotExistsException());
        appointment.getDoctor().removeAppointment(appointment);
        appointmentRepository.cancel(appointment);
    }
}
