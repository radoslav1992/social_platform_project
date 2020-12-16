package com.radoslav.dodnikov.social_platform.customexceptions;

public class NoSuchEntityException extends Exception {

    private String errorValue;

    public NoSuchEntityException() {super();}

    public NoSuchEntityException(String message) {
        super(message);
    }

    public NoSuchEntityException(Exception e) {
        super(e);
    }

    public String getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(String errorValue) {
        this.errorValue = errorValue;
    }
}
