package grizzly.software.recruitment.task.vetclinic.services.interfaces;

import grizzly.software.recruitment.task.vetclinic.exceptions.DoctorNotExistsException;
import grizzly.software.recruitment.task.vetclinic.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface DoctorAppointmentService {
    List<Appointment> getAppointmentsForDoctorForDay(String doctorUUID, LocalDate day) throws DoctorNotExistsException;
}
