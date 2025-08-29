package com.Anoushka.Weather_info_for_pincode.service;

import com.Anoushka.Weather_info_for_pincode.dto.WeatherRequestDTO;
import com.Anoushka.Weather_info_for_pincode.dto.WeatherResponseDTO;

public interface WeatherService {
    WeatherResponseDTO getWeatherForPincode(WeatherRequestDTO request);
}