package com.amazon.ata.music.playlist.service.exceptions;

public class InvalidAttributeChangeException extends InvalidAttributeException{

//    static final long serialVersionUID = -6195014962372199447L;

    public InvalidAttributeChangeException() {
    }

    public InvalidAttributeChangeException(String message) {
        super(message);
    }

    public InvalidAttributeChangeException(Throwable cause) {
        super(cause);
    }

    public InvalidAttributeChangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
