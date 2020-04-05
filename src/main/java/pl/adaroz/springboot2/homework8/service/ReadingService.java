package pl.adaroz.springboot2.homework8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adaroz.springboot2.homework8.model.TemperatureReading;
import pl.adaroz.springboot2.homework8.repository.TemperatureRepository;
import pl.adaroz.springboot2.homework8.weatherapi.apiservice.WeatherService;

import java.time.LocalDateTime;

@Service
public class ReadingService {

    private TemperatureRepository temperatureRepository;
    private WeatherService weatherService;

    @Autowired
    public ReadingService(TemperatureRepository temperatureRepository,
                          WeatherService weatherService) {
        this.temperatureRepository = temperatureRepository;
        this.weatherService = weatherService;
    }

    public void saveReading(TemperatureReading reading) {
        temperatureRepository.save(reading);
    }

    public TemperatureReading getCurrentReading(String city) {
        TemperatureReading reading = new TemperatureReading();
        reading.setCity(city);
        reading.setDateTime(LocalDateTime.now());
        reading.setTemperature(weatherService.getCurrentTempForCity(city));
        return reading;
    }

}
