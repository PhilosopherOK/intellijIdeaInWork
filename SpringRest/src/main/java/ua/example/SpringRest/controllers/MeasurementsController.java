package ua.example.SpringRest.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.example.SpringRest.DTO.MeasurementsDTO;
import ua.example.SpringRest.DTO.MeasurementsResponse;
import ua.example.SpringRest.models.Measurements;
import ua.example.SpringRest.services.MeasurementsService;
import ua.example.SpringRest.util.MeasurementValidator;
import ua.example.SpringRest.util.MeasurementsErrorAdd;
import ua.example.SpringRest.util.MeasurementsErrorResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static ua.example.SpringRest.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {
    private final MeasurementsService measurementsService;
    private final ModelMapper modelMapper;
    private final MeasurementValidator measurementValidator;

    public MeasurementsController(MeasurementsService measurementsService, ModelMapper modelMapper, MeasurementValidator measurementValidator) {
        this.measurementsService = measurementsService;
        this.modelMapper = modelMapper;
        this.measurementValidator = measurementValidator;
    }

    @GetMapping
    public MeasurementsResponse getMeasurements() {
        return new MeasurementsResponse(measurementsService.findAll()
                .stream().map(this::convertToMeasurementsDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/rainyDaysCount")
    public long rainyDays() {
        return measurementsService.findAll().stream()
                .filter(Measurements::isRaining).count();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementsDTO measurementsDTO,
                                                     BindingResult bindingResult) {
        Measurements measurementsToAdd = convertToMeasurements(measurementsDTO);

        measurementValidator.validate(measurementsToAdd, bindingResult);
        if(bindingResult.hasErrors()){
            returnErrorsToClient(bindingResult);
        }
        measurementsService.add(measurementsToAdd);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementsErrorResponse> handleException(MeasurementsErrorAdd e) {
        MeasurementsErrorResponse response = new MeasurementsErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    private Measurements convertToMeasurements(MeasurementsDTO measurementsDTO) {
        return modelMapper.map(measurementsDTO, Measurements.class);
    }

    private MeasurementsDTO convertToMeasurementsDTO(Measurements measurements){
        return modelMapper.map(measurements, MeasurementsDTO.class);
    }

}

