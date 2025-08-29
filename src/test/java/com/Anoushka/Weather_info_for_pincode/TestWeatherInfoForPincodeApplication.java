package com.Anoushka.Weather_info_for_pincode;

import org.springframework.boot.SpringApplication;
import org.testcontainers.utility.TestcontainersConfiguration;

public class TestWeatherInfoForPincodeApplication {

	public static void main(String[] args) {
		SpringApplication.from(WeatherInfoForPincodeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
