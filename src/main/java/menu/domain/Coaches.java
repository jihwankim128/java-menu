package menu.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.exception.BadRequestException;
import menu.exception.ExceptionMessage;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(final List<String> coachNames) {
        validateCoachNameSize(coachNames);
        this.coaches = coachNames.stream().map(Coach::new).collect(Collectors.toList());
    }

    private void validateCoachNameSize(final List<String> coachNames) {
        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new BadRequestException(ExceptionMessage.INVALID_COACH_COUNT);
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

}
