package org.learn.myscheduler.config;

import org.learn.myscheduler.dataImporter.WeatherDataImporter;

public class BeanHandler {
    public static final WeatherDataImporter WEATHER_DATA_IMPORTER = SpringContext.getBean(WeatherDataImporter.class);
}
