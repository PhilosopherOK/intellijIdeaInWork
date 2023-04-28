package ua.example.SpringRest.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/*
CREATE TABLE Measurements(
    id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    value int CHECK ( value < 100 and value > -100 ) NOT NULL,
    raining boolean NOT NULL,
    sensor VARCHAR REFERENCES Sensor (name) on delete CASCADE NOT NULL,
    time_to_do TIMESTAMP NOT NULL
);
 */
@Entity
@Table(name = "Measurements")
public class Measurements {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull
    @Column(name = "value")
    @Min(value = -100, message = "mush be more than -100")
    @Max(value = 100, message = "mush be least than -100")
    private Integer value;

    @NotNull
    @Column(name = "raining")
    private Boolean raining;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private Sensor sensor;

    @Column(name = "time_to_do")
    @NotNull
    private LocalDateTime timeToDo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Boolean isRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public LocalDateTime getTimeToDo() {
        return timeToDo;
    }

    public void setTimeToDo(LocalDateTime timeToDo) {
        this.timeToDo = timeToDo;
    }

}
