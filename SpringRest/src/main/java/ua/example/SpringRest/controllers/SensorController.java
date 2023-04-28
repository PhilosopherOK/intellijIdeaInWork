package ua.example.SpringRest.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.example.SpringRest.DTO.SensorDTO;
import ua.example.SpringRest.models.Sensor;
import ua.example.SpringRest.services.SensorService;
import ua.example.SpringRest.util.MeasurementsErrorAdd;
import ua.example.SpringRest.util.MeasurementsErrorResponse;
import ua.example.SpringRest.util.SensorNameError;
import ua.example.SpringRest.util.SensorValidate;

import javax.validation.Valid;
import java.util.List;

import static ua.example.SpringRest.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final ModelMapper modelMapper;
    private final SensorService sensorService;
    private final SensorValidate sensorValidate;


    @Autowired
    public SensorController(ModelMapper modelMapper, SensorService sensorService, SensorValidate sensorValidate) {
        this.modelMapper = modelMapper;
        this.sensorService = sensorService;
        this.sensorValidate = sensorValidate;
    }

    @GetMapping
    public List<Sensor> allSensors() {
        return sensorService.findAll();
    }


    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                                   BindingResult bindingResult) {

        Sensor sensorToAdd = convertToSensor(sensorDTO);

        sensorValidate.validate(sensorToAdd, bindingResult);

        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        sensorService.register(sensorToAdd);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementsErrorResponse> handleException(MeasurementsErrorAdd e) {
        MeasurementsErrorResponse response = new MeasurementsErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
