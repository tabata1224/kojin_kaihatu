package com.example.demo.service;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Weather;
import com.example.demo.repository.WeatherRepository;

@Service
@Transactional
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    /**
     * レコードを全件取得する。
     * 
     * @return
     */
    public List<Weather> findAllWeatherData() {
        return weatherRepository.findAll();
    }
    // 全件取得
    // public List<Weather> mkList(int id) {
    // List<Weather> weatherDataList = new ArrayList<>();
    // for (Weather weather : weatherRepository.findAll()) {
    // if (weather.getLocation_id() == id) {
    // weatherDataList.add(weather);
    // }
    // }
    // return weatherDataList;
    // }

    public Weather find(int id) {
        return weatherRepository.findById(id).get();
    }
}