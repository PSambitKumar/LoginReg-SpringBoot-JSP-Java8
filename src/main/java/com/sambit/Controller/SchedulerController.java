package com.sambit.Controller;

import com.sambit.Service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

    @GetMapping(value = "/runMoSarkarScheduler")
    public void runScheduler2() throws IOException {
        System.out.println("Running Mo Sarkar Scheduler");
        int responseCode;
       do {
           responseCode = sendDataToMoSarakar();
           if (responseCode != 200) {
               responseCode = callMoSarakarDataList();
           }
           System.out.println("Response Code In Loop: " + responseCode);
       } while (responseCode == 200);

    }

    public int callMoSarakarDataList() throws IOException {
        System.out.println("Calling Mo Sarkar Data List");
        URL url1 = new URL("https://bsky.odisha.gov.in/bsky_service_consume/getMoSarkarDataList");
        HttpURLConnection connection1 = (HttpURLConnection) url1.openConnection();
        connection1.setRequestMethod("GET");
        int responseCode1 = connection1.getResponseCode();
        System.out.println("Response Code: " + responseCode1);
        return responseCode1;
    }
    public int sendDataToMoSarakar() {
        System.out.println("Sending BSKY Data to Mo Sarkar");
        int responseCode = 0;
        try {
            URL url = new URL("https://bsky.odisha.gov.in/bsky_service_consume/moSarkarData");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            System.out.println("Response Content : " + response);
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseCode;
    }

}
