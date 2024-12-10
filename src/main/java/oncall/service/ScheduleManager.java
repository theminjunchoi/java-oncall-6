package oncall.service;

import java.util.List;
import oncall.domain.Worker;

public class ScheduleManager {
    private int month;
    private String startDay;
    private List<Worker> weekDayWorkerSequence;
    private List<Worker> restDayWorkerSequence;

    public void organize(List<String> monthAndStartDay, List<Worker> weekDayWorkerSequence, List<Worker> restDayWorkerSequence) {
        this.month = Integer.parseInt(monthAndStartDay.get(0));
        this.startDay = monthAndStartDay.get(1);
        this.weekDayWorkerSequence = weekDayWorkerSequence;
        this.restDayWorkerSequence = restDayWorkerSequence;
    }
}
