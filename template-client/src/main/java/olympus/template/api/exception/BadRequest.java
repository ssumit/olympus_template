package olympus.template.api.exception;

import olympus.proteus.annotations.ProteusHttpStatus;

@ProteusHttpStatus(400)
public class BadRequest extends RuntimeException {
    public BadRequest() {
    }

    public BadRequest(String message) {
        super(message);
    }

    public BadRequest(String message, Throwable cause) {
        super(message, cause);
    }
}