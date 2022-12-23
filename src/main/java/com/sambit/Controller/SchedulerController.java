package com.sambit.Controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 22/12/2022 - 9:29 PM
 */
@Component
public class SchedulerController {
    private final Logger logger = Logger.getLogger(SchedulerController.class.getName());

    @Scheduled(cron = "1 * * * * ?")
    public void runScheduler(){
        logger.info("Scheduler is running in every minute");
    }

}
