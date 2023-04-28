package ua.example.SpringRest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.example.SpringRest.models.Measurements;
import ua.example.SpringRest.repositories.MeasurementsRepositories;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeasurementsService {
    private final MeasurementsRepositories measurementsRepositories;
    private final SensorService sensorService;

    @Autowired
    public MeasurementsService(MeasurementsRepositories measurementsRepositories, SensorService sensorService) {
        this.measurementsRepositories = measurementsRepositories;
        this.sensorService = sensorService;
    }

    public List<Measurements> findAll() {
        return measurementsRepositories.findAll();
    }

    public void add(Measurements measurements) {
        enrichMeasurement(measurements);
        measurementsRepositories.save(measurements);
    }

    public void enrichMeasurement(Measurements measurements){
        measurements.setSensor(sensorService.findByName(measurements.getSensor().getName()));
        measurements.setTimeToDo(LocalDateTime.now());
    }
}
