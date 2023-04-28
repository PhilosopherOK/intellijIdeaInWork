package ua.example.SpringRest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.example.SpringRest.models.Sensor;
import ua.example.SpringRest.repositories.SensorRepositories;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepositories sensorRepositories;

    @Autowired
    public SensorService(SensorRepositories sensorRepositories) {
        this.sensorRepositories = sensorRepositories;
    }

    public void register(Sensor sensor) {
        sensorRepositories.save(sensor);
    }

    public List<Sensor> findAll() {
        return sensorRepositories.findAll();
    }

    public Sensor findByName(String name) {
        return sensorRepositories.findByName(name).stream().findAny().orElse(null);
    }
}
