package org.learn.myscheduler.weather_data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface  WeatherDataRepository extends JpaRepository<WeatherData, Long>{

    @Query(value="select * from weather_data order by id desc limit 50",nativeQuery=true)
    List<WeatherData> findLast50Datas();
}
