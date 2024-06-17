package org.learn.myscheduler.schedule;

import org.learn.myscheduler.config.BeanHandler;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeatherDataJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("Starting to import weather data............");
        BeanHandler.WEATHER_DATA_IMPORTER.importData();
        log.info("Ending to import weather data............");
    }
}