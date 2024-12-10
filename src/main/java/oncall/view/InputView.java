package oncall.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_MONTH_AND_STARTDAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";

    public String getMonthAndStartDay() {
        System.out.println(INPUT_MONTH_AND_STARTDAY);
        String monthAndStartDayInput = Console.readLine();

    }
}
