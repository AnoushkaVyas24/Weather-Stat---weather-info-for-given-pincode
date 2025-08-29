package com.Anoushka.Weather_info_for_pincode.repository;

import com.Anoushka.Weather_info_for_pincode.model.LocationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationInfo, Long> {

    // Find location by pincode
    Optional<LocationInfo> findByPincode(String pincode);
}
