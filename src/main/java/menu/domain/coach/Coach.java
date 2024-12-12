package menu.domain.coach;

import menu.exception.BadRequestException;
import menu.exception.ExceptionMessage;

public class Coach {

    private static final int MINIMUM_COACH_NAME_LENGTH = 2;
    private static final int MAXIMUM_COACH_NAME_LENGTH = 4;

    private final String name;

    public Coach(final String name) {
        validateCoachName(name);
        this.name = name;
    }

    private static void validateCoachName(final String name) {
        validateNullOrEmptyCheck(name);
        validateCoachNameLengthCheck(name);
    }

    private static void validateCoachNameLengthCheck(final String name) {
        if (name.length() < MINIMUM_COACH_NAME_LENGTH || name.length() > MAXIMUM_COACH_NAME_LENGTH) {
            throw new BadRequestException(ExceptionMessage.INVALID_COACH_NAME_LENGTH);
        }
    }

    private static void validateNullOrEmptyCheck(final String name) {
        if (name == null || name.isEmpty()) {
            throw new BadRequestException(ExceptionMessage.INVALID_COACH_NAME);
        }
    }

    public String getName() {
        return name;
    }

}
