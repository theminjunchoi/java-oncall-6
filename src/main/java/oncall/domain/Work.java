package oncall.domain;

public class Work {
    private final int month;
    private final int date;
    private final String day;
    private Worker worker;
    private DayCategory dayCategory;

    public Work(int month, int date, String day) {
        this.month = month;
        this.date = date;
        this.day = day;
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
}
