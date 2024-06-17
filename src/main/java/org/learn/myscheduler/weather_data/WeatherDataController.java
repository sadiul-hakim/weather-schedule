package org.learn.myscheduler.weather_data;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/weather-data")
@RequiredArgsConstructor
class WeatherDataController {
    private final WeatherDataService weatherDataService;

    @CrossOrigin("http://127.0.0.1:5500/")
    @GetMapping("/last-50")
    ResponseEntity<?> last50(){
        List<WeatherData> last50 = weatherDataService.getLast50();
        return ResponseEntity.ok(last50);
    }
}
