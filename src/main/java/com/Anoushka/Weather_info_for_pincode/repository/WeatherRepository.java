package com.Anoushka.Weather_info_for_pincode.repository;

import com.Anoushka.Weather_info_for_pincode.model.LocationInfo;
import com.Anoushka.Weather_info_for_pincode.model.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherInfo, Long> {

    // Find weather info for a given location and date (to avoid duplicate API calls)
    Optional<WeatherInfo> findByLocationAndDate(LocationInfo location, LocalDate date);
}