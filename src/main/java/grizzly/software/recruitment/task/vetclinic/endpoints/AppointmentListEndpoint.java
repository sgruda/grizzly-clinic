package grizzly.software.recruitment.task.vetclinic.endpoints;

import grizzly.software.recruitment.task.vetclinic.exceptions.AppBaseException;
import grizzly.software.recruitment.task.vetclinic.model.Appointment;
import grizzly.software.recruitment.task.vetclinic.payload.response.ApiResponse;
import grizzly.software.recruitment.task.vetclinic.services.interfaces.DoctorAppointmentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/api/appointments")
public class AppointmentListEndpoint {
    private DoctorAppointmentService doctorAppointmentService;

    public AppointmentListEndpoint(DoctorAppointmentService doctorAppointmentService) {
        this.doctorAppointmentService = doctorAppointmentService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAppointmentsForDoctorForDay(
            @Valid @NotNull(message = "validation.notnull") @Size(max = 36, message = "validation.size")
            @Pattern(regexp = "[0-9A-Za-z-]+", message = "validation.pattern") @RequestParam String doctorUUID,
            @NotNull(message = "validation.notnull") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate day
            ) {
        List<Appointment> appointmentList;
        try {
            appointmentList = doctorAppointmentService.getAppointmentsForDoctorForDay(doctorUUID, day);
        } catch (AppBaseException e) {
            return new ResponseEntity(new ApiResponse(false, e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("appointmentList", appointmentList);

        return ResponseEntity.ok(response);
    }
}
