package org.spongepowered.spunbric.launch;

import java.io.IOException;

/**
 * Thrown when a critical exception is encountered during the launch phase.
 */
public class LaunchException extends RuntimeException {

    private static final long serialVersionUID = 7128575121261470015L;

    public LaunchException() {
    }

    public LaunchException(String message) {
        super(message);
    }

    public LaunchException(String message, Throwable cause) {
        super(message, cause);
    }

    public LaunchException(Throwable cause) {
        super(cause);
    }

}