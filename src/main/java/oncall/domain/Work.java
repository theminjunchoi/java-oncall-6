package oncall.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Work {
    private static final List<String> WEEKDAY = new ArrayList<>(Arrays.asList("월", "화", "수", "목", "금"));
    private static final List<String> WEEKEND = new ArrayList<>(Arrays.asList("토", "일"));

    private final int month;
    private final int date;
    private final String day;
    private Worker worker;
    private DayCategory dayCategory;

    public Work(int month, int date, String day) {
        this.month = month;
        this.date = date;
        this.day = day;
        findDayCategory(day);
    }

    private void findDayCategory(String day) {
        if (WEEKDAY.contains(day)) {
            this.dayCategory = DayCategory.WEEKDAY;
        } else if (WEEKEND.contains(day)) {
            this.dayCategory = DayCategory.WEEKEND;
        }
    }

    public boolean isWorkDay() {
        return dayCategory == DayCategory.WEEKDAY;
    }

    public DayCategory getDayCategory() {
        return dayCategory;
    }

    public void setDayCategory(DayCategory dayCategory){
        this.dayCategory = dayCategory;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public Worker getWorker() {
        return worker;
    }
}
