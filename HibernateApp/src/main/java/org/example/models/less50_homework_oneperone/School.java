package org.example.models.less50_homework_oneperone;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "School")
public class School {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_school;

    @Column(name = "school_number")
    private int school_number;

    @OneToOne
    @JoinColumn(name = "principal_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Principal principal_in_school;

    public School() {
    }

    @Override
    public String toString() {
        return "School{" +
                "id_school=" + id_school +
                ", school_number=" + school_number +
                '}';
    }

    public School(int school_number) {
        this.school_number = school_number;
    }

    public int getId_school() {
        return id_school;
    }

    public void setId_school(int id_school) {
        this.id_school = id_school;
    }

    public int getSchool_number() {
        return school_number;
    }

    public void setSchool_number(int school_number) {
        this.school_number = school_number;
    }

    public Principal getPrincipal_in_school() {
        return principal_in_school;
    }

    public void setPrincipal_in_school(Principal principal) {
        this.principal_in_school = principal;
    }
}
