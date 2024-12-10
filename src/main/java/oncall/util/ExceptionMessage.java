package oncall.util;

public enum ExceptionMessage {
    WRONG_MONTH_FORMAT("올바른 월을 입력해주세요."),
    WRONG_DAY_FORMAT("올바른 요일을 입력해주세요."),
    TOO_MANY_WORKER("근무자의 수는 35명을 초과할 수 없습니다."),
    EMPTY_WORKER_NAME("근무자의 이름이 비어있습니다"),
    LONG_WORKER_NAME("근무자의 이름은 5자를 초과할 수 없습니다."),
    DUPLICATE_WORKER("중복된 근무자가 있습니다.");

    private final String exceptionMessage;
    private static final String ERROR_HEADER = "[ERROR] ";

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_HEADER + this.exceptionMessage;
    }
}
