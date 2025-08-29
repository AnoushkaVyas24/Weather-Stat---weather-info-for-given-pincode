--Table: location_info
CREATE TABLE IF NOT EXISTS location_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pincode VARCHAR(20) NOT NULL UNIQUE,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
);

--Table: weather_info
CREATE TABLE IF NOT EXISTS weather_info (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    location_id BIGINT NOT NULL,
    date DATE NOT NULL,
    temperature DOUBLE NOT NULL,
    description VARCHAR(255) NOT NULL,
    humidity INT NOT NULL,
    wind_speed DOUBLE NOT NULL,

    CONSTRAINT fk_weather_location FOREIGN KEY (location_id)
        REFERENCES location_info(id)
        ON DELETE CASCADE,

    CONSTRAINT uq_weather UNIQUE (location_id, date) -- ensure no duplicate weather entries
);
