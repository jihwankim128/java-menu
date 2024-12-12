package menu.exception;

public class BadRequestException extends IllegalArgumentException {

    private static final String PREFIX = "[ERROR] %s";

    public BadRequestException(final ExceptionMessage message) {
        super(String.format(PREFIX, message.getMessage()));
    }

}
