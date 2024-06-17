package org.learn.myscheduler;

import org.learn.myscheduler.schedule.WeatherDataSchedule;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySchedulerApplication {

    public static void main(String[] args) throws SchedulerException {
        SpringApplication.run(MySchedulerApplication.class, args);

        WeatherDataSchedule.start();
    }
}
