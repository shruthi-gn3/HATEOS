package com.mycompany.hateosappeals;

public class InvalidException extends RuntimeException {
    public InvalidException(Exception ex) {
        super(ex);
    }

    public InvalidException() {}

    private static final long serialVersionUID = 2300194325533639524L;

}
