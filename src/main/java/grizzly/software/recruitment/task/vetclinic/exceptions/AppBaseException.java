package grizzly.software.recruitment.task.vetclinic.exceptions;

public class AppBaseException extends Exception {
    static final public String KEY_DEFAULT = "error.default";

    public AppBaseException() {
        super(KEY_DEFAULT);
    }

    public AppBaseException(String message) {
        super(message);
    }

}
