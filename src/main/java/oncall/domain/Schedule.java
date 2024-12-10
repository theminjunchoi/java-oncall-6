package oncall.domain;

public class Schedule {
    private final int date;
    private final Worker worker;
    private final Day day;

    public Schedule(int date, Worker worker, Day day) {
        this.date = date;
        this.worker = worker;
        this.day = day;
    }
}
