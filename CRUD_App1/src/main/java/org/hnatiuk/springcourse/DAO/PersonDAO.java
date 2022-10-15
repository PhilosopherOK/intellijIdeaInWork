package org.hnatiuk.springcourse.DAO;

import org.hnatiuk.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 5;

    private static final String URL = "jdbc:postgresql://localhost:5432/First_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "619916";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index(){
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }


    public Person show(int id) {
//        return people.stream().filter(person ->
//                person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES ("+ (++PEOPLE_COUNT) + ",'" + person.getName() +
            "'," + person.getAge() + ",'" + person.getEmail() + "')";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updating(int id, Person updatePerson) {
//        Person personToBeUpdating = show(id);
//        personToBeUpdating.setName(updatePerson.getName());
//        personToBeUpdating.setAge(updatePerson.getAge());
//        personToBeUpdating.setEmail(updatePerson.getEmail());
//    }
    }

    public void delete(int id) {
//        people.removeIf(person -> person.getId() == id);
    }
}
