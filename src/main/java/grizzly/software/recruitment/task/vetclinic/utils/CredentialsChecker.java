package grizzly.software.recruitment.task.vetclinic.utils;

import grizzly.software.recruitment.task.vetclinic.exceptions.BadCredentialsException;

public class CredentialsChecker {
    public void checkCredentials(String id, String pin, String correctId, String correctPin) throws BadCredentialsException {
        if(!id.equals(correctId) || !pin.equals(correctPin)) {
            throw new BadCredentialsException();
        }
    }
}
