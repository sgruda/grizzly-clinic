package grizzly.software.recruitment.task.vetclinic.exceptions;

public class AppointmentNotExistsException extends AppBaseException {
    static final public String KEY_APPOINTMENT_NOT_EXIST = "error.appointment.not.exists";

    public AppointmentNotExistsException() {
        super(KEY_APPOINTMENT_NOT_EXIST);
    }
}
