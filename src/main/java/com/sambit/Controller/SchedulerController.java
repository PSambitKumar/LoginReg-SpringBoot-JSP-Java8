package com.sambit.Controller;

import com.sambit.Service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.concurrent.ScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 22/12/2022 - 9:29 PM
 */
@Component
public class SchedulerController {
    private final Logger logger = Logger.getLogger(SchedulerController.class.getName());
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final RegService regService;

    @Autowired
    public SchedulerController(RegService regService) {
        this.regService = regService;
        startScheduler();
    }

    private void startScheduler() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                regService.getAllPersonalDetails();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, 0, 3, TimeUnit.HOURS);
    }

    @Scheduled(cron = "1 * * * * ?")
    public void runScheduler(){
        logger.info("Scheduler is running in every minute");
    }

    //    Run Every 3 hours
    @Scheduled(cron = "0 0 */3 * * ?")
    public void runScheduler3(){
        logger.info("Scheduler is running in every 3 hours");
    }

}
