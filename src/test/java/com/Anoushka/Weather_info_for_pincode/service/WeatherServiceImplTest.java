package com.Anoushka.Weather_info_for_pincode.service;

import com.Anoushka.Weather_info_for_pincode.dto.WeatherRequestDTO;
import com.Anoushka.Weather_info_for_pincode.dto.WeatherResponseDTO;
import com.Anoushka.Weather_info_for_pincode.model.LocationInfo;
import com.Anoushka.Weather_info_for_pincode.model.WeatherInfo;
import com.Anoushka.Weather_info_for_pincode.repository.LocationRepository;
import com.Anoushka.Weather_info_for_pincode.repository.WeatherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {

    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private org.springframework.web.client.RestTemplate restTemplate;

    @InjectMocks
    private WeatherServiceImpl weatherService;

    private LocationInfo locationInfo;

    @BeforeEach
    void setUp() {
        // ✅ use constructor only, no setId
        locationInfo = new LocationInfo("411014", 18.5204, 73.8567);
    }

    @Test
    void testGetWeatherForPincode_WhenDataExists() {
        LocalDate date = LocalDate.of(2020, 10, 15);

        WeatherInfo weatherInfo = new WeatherInfo(
                locationInfo,
                date,
                25.0,
                "Sunny",
                60,
                5.5
        );

        // given mocks
        when(locationRepository.findByPincode("411014")).thenReturn(Optional.of(locationInfo));
        when(weatherRepository.findByLocationAndDate(locationInfo, date)).thenReturn(Optional.of(weatherInfo));

        WeatherRequestDTO request = new WeatherRequestDTO("411014", date);

        WeatherResponseDTO response = weatherService.getWeatherForPincode(request);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getPincode()).isEqualTo("411014");
        assertThat(response.getDescription()).isEqualTo("Sunny");
        assertThat(response.getTemperature()).isEqualTo(25.0);
        assertThat(response.getHumidity()).isEqualTo(60);
        assertThat(response.getWindSpeed()).isEqualTo(5.5);
    }
}