package oncall.domain;

public class Schedule {
    private final int month;
    private final int date;
    private final Worker worker;
    private final Day day;

    public Schedule(int month, int date, Worker worker, Day day) {
        this.month = month;
        this.date = date;
        this.worker = worker;
        this.day = day;
    }
}
