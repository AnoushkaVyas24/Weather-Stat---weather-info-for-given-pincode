package com.Anoushka.Weather_info_for_pincode.controller;

import com.Anoushka.Weather_info_for_pincode.dto.WeatherRequestDTO;
import com.Anoushka.Weather_info_for_pincode.dto.WeatherResponseDTO;
import com.Anoushka.Weather_info_for_pincode.service.WeatherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Example: GET /api/weather?pincode=411014&date=2025-08-30
    @GetMapping
    public WeatherResponseDTO getWeather(
            @RequestParam String pincode,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        WeatherRequestDTO request = new WeatherRequestDTO(pincode, date);
        return weatherService.getWeatherForPincode(request);
    }
}