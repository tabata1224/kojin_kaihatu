package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.WeatherService;

@Controller
public class HelloController {
    @Autowired
    WeatherService weatherService;

    @RequestMapping()
    public String hello(Model model) {

        model.addAttribute("hello", "Hello World!"); // Hello World!の表示

        // 気象データの取得
        // List<Weather> weatherDataList = new ArrayList<>();
        // List<Weather> weatherDataList2 = weatherService.findAllWeatherData();
        // for (int i = 0; i < weatherDataList2.size(); i++) {
        // if (weatherDataList2.get(i).getLocation_id() == 1) {
        // weatherDataList.add(weatherDataList2.get(i));
        // }
        // }
        // weatherDataList.add((weatherService.find(4)));
        // weatherDataList.add((weatherService.find(5)));
        model.addAttribute("weatherDataList", weatherService.find(1));
        return "hello2";
    }
}