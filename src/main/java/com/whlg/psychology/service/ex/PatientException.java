package com.whlg.psychology.service.ex;

public class PatientException extends ServiceException{
    public PatientException() {
        super();
    }

    public PatientException(String message) {
        super(message);
    }

    public PatientException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientException(Throwable cause) {
        super(cause);
    }

    protected PatientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
