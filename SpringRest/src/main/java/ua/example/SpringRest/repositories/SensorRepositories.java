package ua.example.SpringRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.example.SpringRest.models.Sensor;

import java.util.List;
import java.util.Optional;


public interface SensorRepositories extends JpaRepository<Sensor, Integer> {
    List<Sensor> findByName(String name);
}
