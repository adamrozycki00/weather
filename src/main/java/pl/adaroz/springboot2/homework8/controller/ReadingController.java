package pl.adaroz.springboot2.homework8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import pl.adaroz.springboot2.homework8.service.ReadingService;

@Controller
@EnableScheduling
public class ReadingController {

    private ReadingService readingService;

    @Autowired
    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @Scheduled(cron = "0 0 * * * ?")
    public void saveReading() {
        readingService.saveReading(readingService.getCurrentReading("Warsaw"));
    }

}
