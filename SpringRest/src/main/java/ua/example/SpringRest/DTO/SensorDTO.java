package ua.example.SpringRest.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class SensorDTO {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
