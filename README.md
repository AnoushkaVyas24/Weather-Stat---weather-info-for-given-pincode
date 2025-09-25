# 🌦 Weather Info for Pincode

A Spring Boot project to fetch weather details for any Indian pincode by integrating **Geo API** and **OpenWeather API**.  
Weather data is stored in MySQL for re-use and fast retrieval.

---

## 🚀 Features
- Fetch weather by pincode + date.
- Integrates with external APIs (Geo API + OpenWeather).
- Stores location & weather info in MySQL.
- Unit + Integration tests included.
- Global error handling for failed requests.

---

## 🛠 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- JUnit 5, MockMvc
- RestTemplate

---

## ⚙️ Setup Instructions
1. **Clone Repo**
   ```bash
   git clone https://github.com/your-repo/weather-info-for-pincode.git
   cd weather-info-for-pincode

2. **Configure your DB and API keys in application.properties:**
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/weatherdb
   spring.datasource.username=yourUser
   spring.datasource.password=yourPassword
   
   api.google.key=yourGoogleKey
   api.openweather.key=yourWeatherKey

3. **Run the project:**
    ```
   ./mvnw spring-boot:run

4. **Access endpoints at:** http://localhost:8080/api/weather

📖 **Example API Call:**
GET /api/weather?pincode=452001

**Response:**
{
  "pincode": "452001",
  "location": "Indore, MP, India",
  "temperature": 29.3,
  "condition": "Clear Sky",
  "humidity": 41
}

🌟 **Skills Demonstrated:**
-> Microservices architecture
-> External API integration
-> Database caching strategy
-> TDD with JUnit5 & MockMvc
