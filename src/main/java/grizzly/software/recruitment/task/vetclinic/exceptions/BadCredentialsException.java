package grizzly.software.recruitment.task.vetclinic.exceptions;

public class BadCredentialsException extends AppBaseException {
    static final public String KEY_BAD_CREDENTIALS = "error.appointment.bad.credentials";

    public BadCredentialsException() {
        super(KEY_BAD_CREDENTIALS);
    }
}
