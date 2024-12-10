package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.util.Validator;

public class InputView {
    private final static String INPUT_MONTH_AND_STARTDAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";

    public List<String> getMonthAndStartDay() {
        System.out.println(INPUT_MONTH_AND_STARTDAY);
        String monthAndStartDayInput = Console.readLine();
        Validator.validateMonthAndStartDay(monthAndStartDayInput);
        List<String> monthAndStartDay = List.of(monthAndStartDayInput.replace(" ", "").split(","));
        return monthAndStartDay;
    }


}
