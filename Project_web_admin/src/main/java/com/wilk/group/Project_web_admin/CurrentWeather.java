package com.wilk.group.Project_web_admin;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrentWeather implements Serializable {

    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private BigDecimal windSpeed;

// boilerplate getters, constructors, equals, and hashcode omitted
}
//@Service
//public class StubWeatherService {
//
//    public CurrentWeather getCurrentWeather(String city, String country) {
//        return new CurrentWeather("Clear", BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN);
//    }
//}