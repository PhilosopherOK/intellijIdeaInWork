package ua.example.SpringRest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.example.SpringRest.models.Sensor;
import ua.example.SpringRest.services.SensorService;

@Component
public class SensorValidate implements Validator {

    private final SensorService sensorService;

    @Autowired
    public SensorValidate(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;

        if(sensorService.findByName(sensor.getName()) != null){
            errors.rejectValue("name", "this name is taken");
        }

    }
}
