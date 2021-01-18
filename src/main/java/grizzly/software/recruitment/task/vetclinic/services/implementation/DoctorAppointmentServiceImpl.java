package grizzly.software.recruitment.task.vetclinic.services.implementation;

import grizzly.software.recruitment.task.vetclinic.exceptions.DoctorNotExistsException;
import grizzly.software.recruitment.task.vetclinic.model.Appointment;
import grizzly.software.recruitment.task.vetclinic.model.Doctor;
import grizzly.software.recruitment.task.vetclinic.repositories.DoctorRepository;
import grizzly.software.recruitment.task.vetclinic.services.interfaces.DoctorAppointmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorAppointmentServiceImpl implements DoctorAppointmentService {
    private DoctorRepository doctorRepository;

    public DoctorAppointmentServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Appointment> getAppointmentsForDoctorForDay(String doctorUUID, LocalDate day) throws DoctorNotExistsException {
        Doctor doctor = doctorRepository.findByUUID(doctorUUID)
                .orElseThrow(() -> new DoctorNotExistsException());
        return doctor.getAppointmentList()
                .stream()
                .filter(a -> a.getDateTime().getDayOfYear() == day.getDayOfYear())
                .collect(Collectors.toList());
    }
}
