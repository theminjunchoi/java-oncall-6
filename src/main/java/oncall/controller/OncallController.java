package oncall.controller;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.Work;
import oncall.domain.Worker;
import oncall.service.ScheduleManager;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ScheduleManager scheduleManager;

    public OncallController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.scheduleManager = new ScheduleManager();
    }

    public void run() {
       List<String> monthAndStartDay = getStartInfo();
       List<List<Worker>> workerSequence = getWorkInfo();
       List<Worker> weekDayWorkerSequence = workerSequence.get(0);
       List<Worker> restDayWorkerSequence = workerSequence.get(1);
       scheduleManager.organize(monthAndStartDay, weekDayWorkerSequence, restDayWorkerSequence);
       List<Work> workSchedule = scheduleManager.makeSchedule();
       outputView.printSchedule(workSchedule);
    }

    private List<String> getStartInfo() {
        try {
            return inputView.getMonthAndStartDay();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getStartInfo();
        }
    }

    private List<List<Worker>> getWorkInfo() {
        List<List<Worker>> workerSequence = new ArrayList<>();
        try {
            workerSequence.add(inputView.getWeekDayWorkerSequence());
            workerSequence.add(inputView.getRestDayWorkerSequence());
            return workerSequence;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getWorkInfo();
        }
    }
}
