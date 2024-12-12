package menu.exception;

public enum ExceptionMessage {

    INVALID_INPUT("잘못된 입력입니다."),
    INVALID_COACH_NAME("코치의 이름은 필수 값 입니다."),
    INVALID_COACH_NAME_LENGTH("코치의 이름은 최소 2글자, 최대 4글자입니다."),
    INVALID_COACH_COUNT("코치는 최소 2명, 최대 5명입니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}