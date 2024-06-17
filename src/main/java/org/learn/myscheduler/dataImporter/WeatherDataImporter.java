package org.learn.myscheduler.dataImporter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import org.learn.myscheduler.weather_data.WeatherData;
import org.learn.myscheduler.weather_data.WeatherDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherDataImporter {
    private final WeatherDataService weatherDataService;

    @Value("${weather_data.url}")
    private String url;

    public void importData() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String data = response.body();
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> value = mapper.readValue(data, new TypeReference<Map<String,Object>>(){});
            saveData(value);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void saveData(Map<String,Object> value){

        try {
            WeatherData weatherData = new WeatherData();

            Object location = value.get("location");
            if(location instanceof Map locationData){
                weatherData.setName((String) locationData.get("name"));
                weatherData.setLocaltime((String) locationData.get("localtime"));
            }
    
            Object current = value.get("current");
            if(current instanceof Map currentData){
                weatherData.setTemp_c((Double) currentData.get("temp_c"));
                weatherData.setTemp_f((Double) currentData.get("temp_f"));
    
                Map<String,Object> condition = (Map<String,Object>) currentData.get("condition");
                weatherData.setCondition((String) condition.get("text"));
    
                weatherData.setFeelslike_c((Double) currentData.get("feelslike_c"));
                weatherData.setHumidity((Integer) currentData.get("humidity"));
                weatherData.setVis_km((Double) currentData.get("vis_km"));
                weatherData.setDewpoint_c((Double) currentData.get("dewpoint_c"));
            }
    
            weatherDataService.save(weatherData);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();   
        }
    }
}
