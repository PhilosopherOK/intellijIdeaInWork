package ua.example.SpringRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.example.SpringRest.models.Sensor;

import java.util.Optional;


public interface SensorRepositories extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByName(String name);

}
