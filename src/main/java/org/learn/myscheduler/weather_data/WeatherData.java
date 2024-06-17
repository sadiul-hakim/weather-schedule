package org.learn.myscheduler.weather_data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name="weather_data")
public class WeatherData{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name="localtime_text")
    private String localtime;
    private double temp_c;
    private double temp_f;
    @Column(name="condition_text")
    private String condition;
    private double feelslike_c;
    private int humidity;
    private double vis_km;
    private double dewpoint_c;
}
