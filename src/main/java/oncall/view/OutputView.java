package oncall.view;

import java.util.List;
import oncall.domain.Work;

public class OutputView {
    private static final String WORK_FORMAT = "%d월 %d일 %s \n";

    public void printErrorMessage(Exception e) {
        System.out.println(e);
    }

    public void printSchedule(List<Work> workSchedule) {
        for (Work work : workSchedule) {
            System.out.printf(WORK_FORMAT, work.getMonth(), work.getDate(), work.getDay());
        }
    }
}
