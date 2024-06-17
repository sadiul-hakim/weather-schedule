package org.learn.myscheduler.schedule;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeatherDataSchedule {

    private static final String NAME_OF_JOB = "WeatherDataJob";  
    private static final String NAME_OF_GROUP = "WeatherDataGroup";  
    private static final String NAME_OF_TRIGGER = "WeatherDataEveryHourTrigger"; 

    private static Scheduler scheduler;
    public static void start(){
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();

            Trigger trigger = createCronTrigger();
            scheduleJob(trigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage());
        }
    }

    private static Trigger createCronTrigger() { 
         
        //create cron expression 
        // String CRON_EXPRESSION = "0 2 * * * ?"; 
        String CRON_EXPRESSION = "* */5 * * * ?";
         
        //create a trigger to be returned from the method 
        Trigger triggerNew = TriggerBuilder.newTrigger().withIdentity(NAME_OF_TRIGGER, NAME_OF_GROUP) 
                .withSchedule(CronScheduleBuilder.cronSchedule(CRON_EXPRESSION)).build(); 
         
        //return triggerNew to schedule it in main() method 
        return triggerNew; 
    } 

    private static void scheduleJob(Trigger trigger){
        
        JobDetail jobDetail = JobBuilder.newJob(WeatherDataJob.class)
                .withIdentity(NAME_OF_JOB,NAME_OF_GROUP).build();
        try {
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage());
        }
    }
}
