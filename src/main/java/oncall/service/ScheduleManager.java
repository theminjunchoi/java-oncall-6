package oncall.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oncall.domain.DayCategory;
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
    private Holiday holiday = new Holiday();

    public void organize(List<String> monthAndStartDay, List<Worker> weekDayWorkerSequence, List<Worker> restDayWorkerSequence) {
        this.month = Integer.parseInt(monthAndStartDay.get(0));
        this.startDay = monthAndStartDay.get(1);
        this.weekDayWorkerSequence = weekDayWorkerSequence;
        this.restDayWorkerSequence = restDayWorkerSequence;
    }

    public List<Work> makeSchedule() {
        addHoliday();
        List<Work> workSchedule = new ArrayList<>();

        organizeWorkInfo(workSchedule); // month, date, day 지정
        enrollHoliday(workSchedule); // 해당 월 공휴일 지정
        makeWeekDaySchedule(workSchedule); // 평일 근무 지정
        makeRestDaySchedule(workSchedule); // 휴일 근무 지정
        return workSchedule;
    }

    private void organizeWorkInfo(List<Work> workSchedule) {
        int monthSize = MONTH_SIZE_INFO.get(month);
        int startDayIndex = WEEK.indexOf(startDay);
        for (int i = 1; i <= monthSize; i++) {
            workSchedule.add(new Work(month, i, WEEK.get(startDayIndex)));
            startDayIndex = (startDayIndex + 1) % 7;
        }
    }

    private void enrollHoliday(List<Work> workSchedule) {
        List<Integer> holidays = holiday.getCalendar().get(month);
        for (Integer holiday : holidays) {
            DayCategory dayCategory = workSchedule.get(holiday-1).getDayCategory();
            if (dayCategory == DayCategory.WEEKDAY) {
                workSchedule.get(holiday-1).setDayCategory(DayCategory.WEEKDAY_BUT_HOLIDAY);
            } else if (dayCategory == DayCategory.WEEKEND) {
                workSchedule.get(holiday-1).setDayCategory(DayCategory.WEEKEND_AND_HOLIDAY);
            }
        }
    }

    private void makeWeekDaySchedule(List<Work> workSchedule) {
        int weekDayWorkerIndex = 0;
        int weekDayWorkerSize = weekDayWorkerSequence.size();
        for (Work work : workSchedule) {
            if (work.isWorkDay()) {
                work.setWorker(weekDayWorkerSequence.get(weekDayWorkerIndex));
                weekDayWorkerIndex = (weekDayWorkerIndex + 1) % weekDayWorkerSize;
            }
        }
    }

    private void makeRestDaySchedule(List<Work> workSchedule) {
        int restDayWorkerIndex = 0;
        int restDayWorkerSize = restDayWorkerSequence.size();
        for (Work work : workSchedule) {
            if (!work.isWorkDay()) {
                work.setWorker(restDayWorkerSequence.get(restDayWorkerIndex));
                restDayWorkerIndex = (restDayWorkerIndex + 1) % restDayWorkerSize;
            }
        }
    }

    public void addHoliday() {
        holiday.addHoliday(1,1);
        holiday.addHoliday(3,1);
        holiday.addHoliday(5,5);
        holiday.addHoliday(6,6);
        holiday.addHoliday(8,15);
        holiday.addHoliday(10,3);
        holiday.addHoliday(10,9);
        holiday.addHoliday(12,25);
    }
}
