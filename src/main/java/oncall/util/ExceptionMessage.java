package oncall.util;

public enum ExceptionMessage {
    WRONG_MONTH_FORMAT("올바른 월을 입력해주세요."),
    WRONG_DAY_FORMAT("올바른 요일을 입력해주세요.");

    private final String exceptionMessage;
    private static final String ERROR_HEADER = "[ERROR] ";

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_HEADER + this.exceptionMessage;
    }
}
