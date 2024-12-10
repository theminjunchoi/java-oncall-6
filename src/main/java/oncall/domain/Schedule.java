package oncall.domain;

public class Schedule {
    private final int month;
    private final int date;
    private final String day;
    private final Worker worker;
    private final DayCategory dayCategory;

    public Schedule(int month, int date, String day, Worker worker, DayCategory dayCategory) {
        this.month = month;
        this.date = date;
        this.day = day;
        this.worker = worker;
        this.dayCategory = dayCategory;
    }
}
