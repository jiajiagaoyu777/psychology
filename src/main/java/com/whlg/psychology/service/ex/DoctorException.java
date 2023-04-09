package com.whlg.psychology.service.ex;

public class DoctorException extends ServiceException{
    public DoctorException() {
        super();
    }

    public DoctorException(String message) {
        super(message);
    }

    public DoctorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorException(Throwable cause) {
        super(cause);
    }

    protected DoctorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
