package ua.example.SpringRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.example.SpringRest.models.Measurements;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.util.List;

@Repository
public interface MeasurementsRepositories extends JpaRepository<Measurements, Integer> {
    List<Measurements> findByRaining(boolean raining);
}
