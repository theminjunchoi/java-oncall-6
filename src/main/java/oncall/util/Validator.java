package oncall.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private final static int JANUARY = 1;
    private final static int DECEMBER = 12;
    private final static int MAX_WORKER_NUMBER = 35;
    private final static int MAX_WORKER_NAME_LENGTH = 5;

    public static void validateMonthAndStartDay(String uncheckedInput) {
        List<String> monthAndStartDay = getSplit(uncheckedInput);
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

    public static void validateWorkerSequence(String uncheckedWorkerSequence) {
        validateWorkerNumber(uncheckedWorkerSequence);
        validateEachWorkerName(uncheckedWorkerSequence);
        validateDuplicateWorker(uncheckedWorkerSequence);
    }

    private static void validateWorkerNumber(String uncheckedWorkerSequence) {
        List<String> workers = getSplit(uncheckedWorkerSequence);
        if (workers.size() > MAX_WORKER_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.TOO_MANY_WORKER.getExceptionMessage());
        }
    }

    private static void validateEachWorkerName(String uncheckedWorkerSequence) {
        List<String> workers = getSplit(uncheckedWorkerSequence);
        for (String worker : workers) {
            if (worker.isBlank()) {
                throw new IllegalArgumentException(ExceptionMessage.EMPTY_WORKER_NAME.getExceptionMessage());
            }
            if (worker.length() > MAX_WORKER_NAME_LENGTH) {
                throw new IllegalArgumentException(ExceptionMessage.LONG_WORKER_NAME.getExceptionMessage());
            }
        }
    }

    private static void validateDuplicateWorker(String uncheckedWorkerSequence) {
        List<String> workers = getSplit(uncheckedWorkerSequence);
        Set<String> uniqueWorkers = new HashSet<>(workers);
        if (workers.size() != uniqueWorkers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_WORKER.getExceptionMessage());
        }
    }

    private static List<String> getSplit(String uncheckedInput) {
        return List.of(uncheckedInput.replace(" ", "").split(","));
    }
}
