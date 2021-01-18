package grizzly.software.recruitment.task.vetclinic.exceptions;

public class DoctorNotExistsException extends AppBaseException {
    static final public String KEY_DOCTOR_NOT_EXIST = "error.doctor.not.exists";

    public DoctorNotExistsException() {
        super(KEY_DOCTOR_NOT_EXIST);
    }
}
