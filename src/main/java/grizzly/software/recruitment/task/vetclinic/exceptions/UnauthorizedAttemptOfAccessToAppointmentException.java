package grizzly.software.recruitment.task.vetclinic.exceptions;

public class UnauthorizedAttemptOfAccessToAppointmentException extends AppBaseException {
    static final public String KEY_UNAUTHORIZED_ATTEMPT_OF_ACCESS_TO_APPOINTMENT = "error.unauthorized.attempt.of.access";

    public UnauthorizedAttemptOfAccessToAppointmentException() {
        super(KEY_UNAUTHORIZED_ATTEMPT_OF_ACCESS_TO_APPOINTMENT);
    }
}
