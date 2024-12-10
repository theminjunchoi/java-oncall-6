package oncall.view;

import java.util.List;
import oncall.domain.DayCategory;
import oncall.domain.Work;

public class OutputView {
    private static final String WORK_FORMAT = "%d월 %d일 %s \n";
    private static final String WORK_HOLIDAY_FORMAT = "%d월 %d일 %s(휴일) \n";


    public void printErrorMessage(Exception e) {
        System.out.println(e);
    }

    public void printSchedule(List<Work> workSchedule) {
        for (Work work : workSchedule) {
            if (work.getDayCategory() == DayCategory.WEEKDAY|| work.getDayCategory() == DayCategory.WEEKEND) {
                System.out.printf(WORK_FORMAT, work.getMonth(), work.getDate(), work.getDay());

            } else if (work.getDayCategory() == DayCategory.WEEKDAY_BUT_HOLIDAY || work.getDayCategory() == DayCategory.WEEKEND_AND_HOLIDAY) {
                System.out.printf(WORK_HOLIDAY_FORMAT, work.getMonth(), work.getDate(), work.getDay());
            }
        }
    }
}
