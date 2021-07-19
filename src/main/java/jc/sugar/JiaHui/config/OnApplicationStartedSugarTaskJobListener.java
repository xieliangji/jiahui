package jc.sugar.JiaHui.config;

import jc.sugar.JiaHui.service.SugarTasksSchedulerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Code 谢良基 2021/7/19
 */
@Component
public class OnApplicationStartedSugarTaskJobListener implements CommandLineRunner {

    private final SugarTasksSchedulerService schedulerService;


    public OnApplicationStartedSugarTaskJobListener(SugarTasksSchedulerService schedulerService){
        this.schedulerService = schedulerService;
    }

    @Override
    public void run(String... args) throws Exception {
        schedulerService.loadSugarTasks();
    }
}
