package pl.adaroz.springboot2.homework8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adaroz.springboot2.homework8.model.TemperatureReading;
import pl.adaroz.springboot2.homework8.repository.TemperatureRepository;
import pl.adaroz.springboot2.homework8.weatherapi.apiservice.WeatherApiService;

import java.time.LocalDateTime;

@Service
public class ReadingService {

    private WeatherApiService weatherApiService;
    private TemperatureRepository temperatureRepository;

    @Autowired
    public ReadingService(TemperatureRepository temperatureRepository,
                          WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
        this.temperatureRepository = temperatureRepository;
    }

    public void saveReading(TemperatureReading reading) {
        temperatureRepository.save(reading);
    }

    public TemperatureReading getCurrentReading(String city) {
        TemperatureReading reading = new TemperatureReading();
        reading.setCity(city);
        reading.setDateTime(LocalDateTime.now());
        reading.setTemperature(weatherApiService.getCurrentTempForCity(city));
        return reading;
    }

}
