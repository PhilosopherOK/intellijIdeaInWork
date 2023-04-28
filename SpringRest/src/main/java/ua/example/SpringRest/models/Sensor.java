package ua.example.SpringRest.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/*
CREATE TABLE Sensor(
    id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR UNIQUE NOT NULL
);
 */
@Entity
@Table(name = "Sensor")
public class Sensor implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name mush be empty")
    @Size(min = 3, max = 30, message = "name mush be between 3 and 30 letters")
    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
