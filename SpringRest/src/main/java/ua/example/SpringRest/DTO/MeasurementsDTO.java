package ua.example.SpringRest.DTO;

import org.hibernate.annotations.Cascade;
import ua.example.SpringRest.models.Sensor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MeasurementsDTO {

    @NotNull
    @Min(value = -100, message = "mush be more than -100")
    @Max(value = 100, message = "mush be least than -100")
    private Integer value;

    @NotNull
    private Boolean raining;

    @NotNull
    private Sensor sensor;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
