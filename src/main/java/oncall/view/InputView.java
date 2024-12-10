package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import oncall.domain.Worker;
import oncall.util.Validator;

public class InputView {
    private final static String INPUT_MONTH_AND_STARTDAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private final static String INPUT_WEEKDAY_WORKER_SEQUENCE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요>";
    private final static String INPUT_RESTDAY_WORKER_SEQUENCE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>";


    public List<String> getMonthAndStartDay() {
        System.out.println(INPUT_MONTH_AND_STARTDAY);
        String monthAndStartDayInput = Console.readLine();
        Validator.validateMonthAndStartDay(monthAndStartDayInput);
        List<String> monthAndStartDay = List.of(monthAndStartDayInput.replace(" ", "").split(","));
        return monthAndStartDay;
    }

    public List<Worker> getWeekDayWorkerSequence() {
        System.out.println(INPUT_WEEKDAY_WORKER_SEQUENCE);
        return getWorkers();
    }

    public List<Worker> getRestDayWorkerSequence() {
        System.out.println(INPUT_RESTDAY_WORKER_SEQUENCE);
        return getWorkers();
    }

    private static List<Worker> getWorkers() {
        String workerSequenceInput = Console.readLine();
        Validator.validateWorkerSequence(workerSequenceInput);
        List<String> workerSequence = List.of(workerSequenceInput.replace(" ", "").split(","));
        List<Worker> workers = new ArrayList<>();
        for (String workerName : workerSequence) {
            workers.add(new Worker(workerName));
        }
        return workers;
    }
}
