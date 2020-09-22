package com.realdolmen.springmvc.doa;

import com.realdolmen.springmvc.models.Animal;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.realdolmen.springmvc.dbacces.LoginDetails.*;

@Repository
public class AnimalDAOImpl implements AnimalDAO {
    private List<Animal> animals = new ArrayList<Animal>();
    public List<Animal> getAllAnimals() {
        Connection conn = null;
        String sql = String.format("SELECT * FROM thezoo.animals;");
        try {
            conn = DriverManager.getConnection(url, user, pass); {
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery(sql);
                List<Animal> animalList = new ArrayList<>();

                /** While there are matches found print out the result */
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String animalName = rs.getString(2);
                    String species = rs.getString(3);
                    String foodType = rs.getString(4);

                    Animal animal = new Animal();
                    animal.setId(id);
                    animal.setAnimalName(animalName);
                    animal.setSpecies(species);
                    animal.setFoodType(foodType);
                    animalList.add(animal);
                    System.out.println(id  + animalName + species + foodType);
                } return animalList;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return Collections.emptyList();
    }


    /*
        public int addEmployee(Employee employee) {

            try (PreparedStatement preparedStatement = createConnection().prepareStatement("insert into employees(id, firstname, lastname) values ((SELECT LAST_INSERT_ID()),?,?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, employee.getFirstName());
                preparedStatement.setString(2, employee.getLastName());
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                return resultSet.getInt(1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return 0;
        }

        @Override
        public void deleteById(int id) {
            try (PreparedStatement preparedStatement = createConnection().prepareStatement("delete from employees where id = ? ")) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/
    public Connection createConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return conn;
    }
}
