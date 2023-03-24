package ua.example.SpringRest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.example.SpringRest.models.Measurements;
import ua.example.SpringRest.repositories.MeasurementsRepositories;

import java.time.LocalDateTime;

@Service
public class MeasurementsService {
    private final MeasurementsRepositories measurementsRepositories;

    @Autowired
    public MeasurementsService(MeasurementsRepositories measurementsRepositories) {
        this.measurementsRepositories = measurementsRepositories;
    }

    public void registration(Measurements measurements){
        measurements.setTimeToDo(LocalDateTime.now());
        measurementsRepositories.save(measurements);
    }

}
