package oncall.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oncall.domain.Work;
import oncall.domain.Worker;

public class ScheduleManager {
    private static final List<Integer> MONTH_SIZE_INFO
            = new ArrayList<>(Arrays.asList(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));
    private static final List<String> WEEK = new ArrayList<>(Arrays.asList("월", "화", "수", "목", "금", "토", "일"));

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

    public List<Work> makeSchedule() {
        List<Work> workSchedule = new ArrayList<>();
        int monthSize = MONTH_SIZE_INFO.get(month);
        int startDayIndex = WEEK.indexOf(startDay);
        for (int i = 1; i <= monthSize; i++) {
            workSchedule.add(new Work(month, i, WEEK.get(startDayIndex)));
            startDayIndex = (startDayIndex + 1) % 7;
        }
        return workSchedule;
    }
}
