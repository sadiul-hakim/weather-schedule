package org.learn.myscheduler.weather_data;

import java.util.List;

import org.learn.myscheduler.exception.NotFounfException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherDataService {
     private final WeatherDataRepository weatherDataRepository;
    public WeatherData save(WeatherData weatherData){
        return weatherDataRepository.save(weatherData);
    }

    public List<WeatherData> getAll(){
        return weatherDataRepository.findAll();
    }

    public List<WeatherData> getLast50(){
        return weatherDataRepository.findLast50Datas();
    }

    public WeatherData getById(long id) throws NotFounfException{
        return weatherDataRepository.findById(id)
        .orElseThrow(()-> new NotFounfException("WeatherData not found with id"+id));
    }
}
