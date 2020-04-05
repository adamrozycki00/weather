package pl.adaroz.springboot2.homework8.weatherapi.apiservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.adaroz.springboot2.homework8.weatherapi.apiclasses.WeatherInfo;

@Service
public class WeatherService {

    public WeatherInfo getWeatherInfo(String cityParam) {
        RestTemplate restTemplate = new RestTemplate();
        final String API_KEY_PARAM = "07c0c3519429b51e18c2e2e2034b6dd3";
        final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
        final String UNITS_PARAM = "metric";
        String url = BASE_URL + "?q=" + cityParam + "&units=" + UNITS_PARAM + "&appid=" + API_KEY_PARAM;
        WeatherInfo weatherInfo = restTemplate.getForObject(url, WeatherInfo.class);
        return weatherInfo;
    }

    public double getCurrentTempForCity(String city) {
        return getWeatherInfo(city).getMain().getTemp();
    }

}
