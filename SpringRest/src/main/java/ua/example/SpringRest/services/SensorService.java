package ua.example.SpringRest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.example.SpringRest.DTO.SensorDTO;
import ua.example.SpringRest.models.Sensor;
import ua.example.SpringRest.repositories.SensorRepositories;

import java.util.Optional;

@Service
public class SensorService {

    private final SensorRepositories sensorRepositories;

    @Autowired
    public SensorService(SensorRepositories sensorRepositories) {
        this.sensorRepositories = sensorRepositories;
    }

    public void save(Sensor sensor){
    sensorRepositories.save(sensor);
    }


    public Optional<Sensor> findByName(String name){
        return sensorRepositories.findByName(name);
    }
}
