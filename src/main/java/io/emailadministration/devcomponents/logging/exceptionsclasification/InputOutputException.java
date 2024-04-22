package io.emailadministration.devcomponents.logging.exceptionsclasification;

import java.io.IOException;

public class InputOutputException extends Exception {
    public InputOutputException() {
        super();
    }

    public InputOutputException(String message) {
        super(message);
    }

    public InputOutputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputOutputException(Throwable cause) {
        super(cause);
    }
}
