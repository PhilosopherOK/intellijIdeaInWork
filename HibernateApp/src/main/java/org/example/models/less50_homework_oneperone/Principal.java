package org.example.models.less50_homework_oneperone;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Principal")
public class Principal {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "principal_in_school")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private School inSchool;

    public Principal(){
    }

    @Override
    public String toString() {
        return "Principal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Principal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public School getInSchool() {
        return inSchool;
    }

    public void setInSchool(School inSchool) {
        this.inSchool = inSchool;
        this.getInSchool().setPrincipal_in_school(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
