package oncall.domain;

public class Worker {
    private final String workerName;

    public Worker(String workerName) {
        this.workerName = workerName;
    }

    public String getName() {
        return workerName;
    }
}
