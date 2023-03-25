package ua.example.SpringRest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.example.SpringRest.models.Measurements;
import ua.example.SpringRest.services.SensorService;

import javax.persistence.Column;

@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurements.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurements measurements = (Measurements) target;

        if (measurements.getSensor() == null){
            return;
        }
        if(sensorService.findByName(measurements.getSensor().getName()) == null){
            errors.rejectValue("sensor", "not found register sensor");
        }

    }
}
