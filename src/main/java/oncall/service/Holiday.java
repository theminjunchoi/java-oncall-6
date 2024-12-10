package oncall.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Holiday {
    private Map<Integer, List<Integer>> holiday;

    public Holiday() {
        this.holiday = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            holiday.put(i, new ArrayList<>());
        }
    }

    public void addHoliday(int month, int date){
        holiday.get(month).add(date);
    }

    public Map<Integer, List<Integer>> getCalendar() {
        return holiday;
    }
}
