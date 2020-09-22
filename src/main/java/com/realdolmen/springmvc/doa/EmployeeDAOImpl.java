package com.realdolmen.springmvc.doa;

import com.realdolmen.springmvc.models.Employee;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.realdolmen.springmvc.dbacces.LoginDetails.*;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private List<Employee> employees = new ArrayList<Employee>();
    public List<Employee> getAllEmployees() {
        Connection conn = null;
        String sql = String.format("SELECT * FROM thezoo.employees;");
        try {
            conn = DriverManager.getConnection(url, user, pass); {
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery(sql);
                List<Employee> employeeList = new ArrayList<>();

                /** While there are matches found print out the result */
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String firstName = rs.getString(2);
                    String lastName = rs.getString(3);

                    Employee employee = new Employee();
                    employee.setId(id);
                    employee.setFirstName(firstName);
                    employee.setLastName(lastName);
                    employeeList.add(employee);
                    //System.out.format("%s %s %s %n", "Employee ID: " + id, "First Name: " + firstName, " Last Name: " + lastName);
                } return employeeList;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return Collections.emptyList();
    }

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
    public void update(Employee employee) {
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("UPDATE `thezoo`.`employees` SET firstName= ? , lastName=? where id = ? ")) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, employee.getId());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Employee findById(int id) {
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("select * from employees where id = ? ")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();

            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setFirstName(resultSet.getString("firstname"));
            employee.setLastName(resultSet.getString("lastname"));

            return employee;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return null;
    }


    @Override
    public void deleteById(int id) {
        try (PreparedStatement preparedStatement = createConnection().prepareStatement("delete from employees where id = ? ")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Connection createConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return conn;
    }
}
