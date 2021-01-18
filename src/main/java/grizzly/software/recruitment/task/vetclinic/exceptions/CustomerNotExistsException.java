package grizzly.software.recruitment.task.vetclinic.exceptions;

public class CustomerNotExistsException extends AppBaseException {
    static final public String KEY_CUSTOMER_NOT_EXIST = "error.customer.not.exists";

    public CustomerNotExistsException() {
        super(KEY_CUSTOMER_NOT_EXIST);
    }
}