package pl.adaroz.springboot2.homework8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.adaroz.springboot2.homework8.model.TemperatureReading;

@Repository
public interface TemperatureRepository extends JpaRepository<TemperatureReading, Long> {
}
