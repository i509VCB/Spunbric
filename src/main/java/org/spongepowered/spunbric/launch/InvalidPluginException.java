package org.spongepowered.spunbric.launch;

public final class InvalidPluginException extends RuntimeException {

    private static final long serialVersionUID = -2566993626556875750L;

    public InvalidPluginException() {
    }

    public InvalidPluginException(String message) {
        super(message);
    }

    public InvalidPluginException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPluginException(Throwable cause) {
        super(cause);
    }

}