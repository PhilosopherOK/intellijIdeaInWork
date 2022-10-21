package org.hnatiuk.springcourse.DAO;

import org.hnatiuk.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional <Person> show(String email){
        return jdbcTemplate.query("SELECT * FROM Person WHERE email=?", new Object[]{email},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person( name, age, email, address) VALUES(?, ?, ?, ?)",
                person.getName(), person.getAge(), person.getEmail() , person.getAddress());

    }

    public void updating(int id, Person updatePerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=?, address=? WHERE id=?",
                updatePerson.getName(), updatePerson.getAge(), updatePerson.getEmail(),updatePerson.getAddress(), id);
    }


    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person Where id=?");
    }
}
