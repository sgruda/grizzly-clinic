package grizzly.software.recruitment.task.vetclinic.services.implementation;

import grizzly.software.recruitment.task.vetclinic.exceptions.BadCredentialsException;
import grizzly.software.recruitment.task.vetclinic.exceptions.CustomerNotExistsException;
import grizzly.software.recruitment.task.vetclinic.exceptions.DoctorNotExistsException;
import grizzly.software.recruitment.task.vetclinic.model.Appointment;
import grizzly.software.recruitment.task.vetclinic.model.Customer;
import grizzly.software.recruitment.task.vetclinic.model.Doctor;
import grizzly.software.recruitment.task.vetclinic.repositories.AppointmentRepository;
import grizzly.software.recruitment.task.vetclinic.repositories.CustomerRepository;
import grizzly.software.recruitment.task.vetclinic.repositories.DoctorRepository;
import grizzly.software.recruitment.task.vetclinic.services.interfaces.AddAppointmentService;
import grizzly.software.recruitment.task.vetclinic.utils.CredentialsChecker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AddAppointmentServiceImpl implements AddAppointmentService {
    private CustomerRepository customerRepository;
    private DoctorRepository doctorRepository;
    private AppointmentRepository appointmentRepository;

    public AddAppointmentServiceImpl(CustomerRepository customerRepository, DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
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
    public Doctor getDoctor(String doctorUUID) throws DoctorNotExistsException {
        return doctorRepository.findByUUID(doctorUUID)
                .orElseThrow(() -> new DoctorNotExistsException());
    }

    @Override
    public void checkCredentials(String id, String pin, Customer customer) throws BadCredentialsException {
        CredentialsChecker credentialsChecker = new CredentialsChecker();
        credentialsChecker.checkCredentials(id, pin, customer.getId(), customer.getPin());
    }

    @Override
    public void addAppointment(Customer customer, Doctor doctor, LocalDateTime localDateTime) {
        Appointment appointment = new Appointment(doctor, customer, localDateTime);
        appointmentRepository.add(appointment);
        doctor.addAppointment(appointment);
        customer.addAppointment(appointment);
    }
}
