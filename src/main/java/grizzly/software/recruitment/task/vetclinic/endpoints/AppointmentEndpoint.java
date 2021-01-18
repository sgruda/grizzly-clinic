package grizzly.software.recruitment.task.vetclinic.endpoints;

import grizzly.software.recruitment.task.vetclinic.exceptions.AppBaseException;
import grizzly.software.recruitment.task.vetclinic.model.Customer;
import grizzly.software.recruitment.task.vetclinic.model.Doctor;
import grizzly.software.recruitment.task.vetclinic.payload.request.AddAppointmentRequest;
import grizzly.software.recruitment.task.vetclinic.payload.request.CancelAppointmentRequest;
import grizzly.software.recruitment.task.vetclinic.payload.response.ApiResponse;
import grizzly.software.recruitment.task.vetclinic.services.interfaces.AddAppointmentService;
import grizzly.software.recruitment.task.vetclinic.services.interfaces.CancelAppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentEndpoint {
    private AddAppointmentService addAppointmentService;
    private CancelAppointmentService cancelAppointmentService;

    public AppointmentEndpoint(AddAppointmentService addAppointmentService, CancelAppointmentService cancelAppointmentService) {
        this.addAppointmentService = addAppointmentService;
        this.cancelAppointmentService = cancelAppointmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAppointment(@Valid @RequestBody AddAppointmentRequest addAppointmentRequest) {
        try {
            Doctor doctor = addAppointmentService.getDoctor(addAppointmentRequest.getDoctorUUID());
            Customer customer = addAppointmentService.getCustomer(addAppointmentRequest.getCustomerUUID());
            addAppointmentService.checkCredentials(
                    addAppointmentRequest.getCustomerId(),
                    addAppointmentRequest.getCustomerPin(),
                    customer
            );
            addAppointmentService.addAppointment(customer, doctor, addAppointmentRequest.getAppointmentDate());
        } catch (AppBaseException e) {
            return new ResponseEntity(new ApiResponse(false, e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new ApiResponse(true, "appointment.correctly.added"));
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<?> cancelAppointment(@Valid @RequestBody CancelAppointmentRequest cancelAppointmentRequest) {
        try {
            Customer customer = cancelAppointmentService.getCustomer(cancelAppointmentRequest.getCustomerUUID());
            cancelAppointmentService.checkCredentials(
                    cancelAppointmentRequest.getCustomerId(),
                    cancelAppointmentRequest.getCustomerPin(),
                    customer
            );
            cancelAppointmentService.cancelAppointment(cancelAppointmentRequest.getAppointmentUUID(), customer.getUuid());
        } catch (AppBaseException e) {
            return new ResponseEntity(new ApiResponse(false, e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new ApiResponse(true, "appointment.correctly.cancelled"));
    }
}
