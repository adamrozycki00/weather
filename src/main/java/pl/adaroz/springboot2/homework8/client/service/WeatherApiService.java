package pl.adaroz.springboot2.homework8.client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.adaroz.springboot2.homework8.client.apiclasses.WeatherInfo;

@Service
public class WeatherApiService {

    public WeatherInfo getWeatherInfo(String cityParam) {
        final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
        final String API_KEY_PARAM = "2c9ddfaf37b04cafa226704ab7a66458";
        final String UNITS_PARAM = "metric";
        String url = BASE_URL + "?q=" + cityParam + "&units=" + UNITS_PARAM + "&appid=" + API_KEY_PARAM;
        return new RestTemplate().getForObject(url, WeatherInfo.class);
    }

    public double getCurrentTempForCity(String city) {
        return getWeatherInfo(city).getMain().getTemp();
    }

}
