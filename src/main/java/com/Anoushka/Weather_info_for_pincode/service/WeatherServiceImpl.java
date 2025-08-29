package com.Anoushka.Weather_info_for_pincode.service;

import com.Anoushka.Weather_info_for_pincode.dto.WeatherRequestDTO;
import com.Anoushka.Weather_info_for_pincode.dto.WeatherResponseDTO;
import com.Anoushka.Weather_info_for_pincode.model.LocationInfo;
import com.Anoushka.Weather_info_for_pincode.model.WeatherInfo;
import com.Anoushka.Weather_info_for_pincode.repository.LocationRepository;
import com.Anoushka.Weather_info_for_pincode.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    private final LocationRepository locationRepository;
    private final RestTemplate restTemplate;

    @Value("${api.openweather.key}")
    private String openWeatherApiKey;

    @Value("${api.geocoding.key}")
    private String geoApiKey;

    public WeatherServiceImpl(WeatherRepository weatherRepository,
                              LocationRepository locationRepository,
                              RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.locationRepository = locationRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherResponseDTO getWeatherForPincode(WeatherRequestDTO request) {
        String pincode = request.getPincode();
        LocalDate date = request.getForDate();

        // Step 1: Find LocationInfo for pincode
        LocationInfo location = locationRepository.findByPincode(pincode)
                .orElseGet(() -> fetchAndSaveLocation(pincode));

        // Step 2: Check if weather for that location & date already exists
        Optional<WeatherInfo> existingWeather = weatherRepository.findByLocationAndDate(location, date);
        if (existingWeather.isPresent()) {
            return mapToResponse(existingWeather.get());
        }

        // Step 3: If not, fetch from external API
        WeatherInfo fetchedWeather = fetchWeatherFromAPI(location, date);

        // Step 4: Save in DB
        WeatherInfo saved = weatherRepository.save(fetchedWeather);

        // Step 5: Return DTO
        return mapToResponse(saved);
    }

    private LocationInfo fetchAndSaveLocation(String pincode) {
        // Example: Use Google Maps or OpenWeather Geocoding API
        String url = "http://api.openweathermap.org/geo/1.0/zip?zip=" + pincode + ",IN&appid=" + openWeatherApiKey;
        var response = restTemplate.getForObject(url, GeoApiResponse.class);

        LocationInfo location = new LocationInfo(
                pincode,
                response.getLat(),
                response.getLon()
        );
        return locationRepository.save(location);
    }

    private WeatherInfo fetchWeatherFromAPI(LocationInfo location, LocalDate date) {
        // Example: Using OpenWeather One Call API
        String url = "https://api.openweathermap.org/data/2.5/weather?lat="
                + location.getLatitude() + "&lon=" + location.getLongitude()
                + "&appid=" + openWeatherApiKey + "&units=metric";

        var response = restTemplate.getForObject(url, OpenWeatherResponse.class);

        return new WeatherInfo(
                location,
                date,
                response.getMain().getTemp(),
                response.getWeather()[0].getDescription(),
                response.getMain().getHumidity(),
                response.getWind().getSpeed()
        );
    }

    private WeatherResponseDTO mapToResponse(WeatherInfo weatherInfo) {
        return new WeatherResponseDTO(
                weatherInfo.getLocation().getPincode(),
                weatherInfo.getDate(),
                weatherInfo.getTemperature(),
                weatherInfo.getDescription(),
                weatherInfo.getHumidity(),
                weatherInfo.getWindSpeed()
        );
    }
}
