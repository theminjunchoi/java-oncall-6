package oncall.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private final static int JANUARY = 1;
    private final static int DECEMBER = 12;

    public static void validateMonthAndStartDay(String uncheckedInput) {
        List<String> monthAndStartDay = List.of(uncheckedInput.replace(" ", "").split(","));
        validateMonth(monthAndStartDay.get(0));
        validateStartDay(monthAndStartDay.get(1));
    }

    private static void validateMonth(String uncheckedMonth) {
        int month = Integer.parseInt(uncheckedMonth);
        if (month < JANUARY || month > DECEMBER) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_MONTH_FORMAT.getExceptionMessage());
        }
    }

    private static void validateStartDay(String uncheckedStartDay) {
        List<String> week = new ArrayList<>(Arrays.asList("월", "화", "수", "목", "금", "토", "일"));
        if (!week.contains(uncheckedStartDay)) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_DAY_FORMAT.getExceptionMessage());
        }
    }
}
