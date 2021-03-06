package grizzly.software.recruitment.task.vetclinic.payload.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CancelAppointmentRequest {
    @NotNull(message = "validation.notnull")
    @Size(max = 36, message = "validation.size")
    @Pattern(regexp = "[0-9A-Za-z-]+", message = "validation.pattern")
    private String appointmentUUID;

    @NotNull(message = "validation.notnull")
    @Size(max = 36, message = "validation.size")
    @Pattern(regexp = "[0-9A-Za-z-]+", message = "validation.pattern")
    private String customerUUID;

    @NotNull(message = "validation.notnull")
    @Size(min = 4, max = 4, message = "validation.size")
    @Pattern(regexp = "[0-9]+", message = "validation.pattern")
    private String customerId;

    @NotNull(message = "validation.notnull")
    @Size(min = 4, max = 4, message = "validation.size")
    @Pattern(regexp = "[0-9]+", message = "validation.pattern")
    private String customerPin;

    public String getAppointmentUUID() {
        return appointmentUUID;
    }

    public String getCustomerUUID() {
        return customerUUID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerPin() {
        return customerPin;
    }

}
