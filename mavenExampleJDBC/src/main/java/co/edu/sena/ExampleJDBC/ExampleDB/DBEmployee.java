/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.ExampleDB;

import co.edu.sena.ExampleJDBC.Utils.MessageUtils;
import co.edu.sena.ExampleJDBC.model.Employee;
import co.edu.sena.ExampleJDBC.model.EmployeeType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:20/03/2025
 *
 * @author alejo Objetive: permite consultas y transacciones en la tabla
 * employee
 */
public class DBEmployee extends DBConnection {

    public void insert(Employee employee) {
        try {
            connect();
            String sql = "insert into employee values ( ?,?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, employee.getDocument());
            preparedStatement.setString(2, employee.getFullname());
            preparedStatement.setString(3, employee.getAddres());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setInt(5, employee.getEmployeeType().getId());//Llave FK
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al insertar el tipo de llave"
                    + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public void update(Employee employee) {

        try {
            connect();
            String sql = "UPDATE employee SET fullname= ?, direccion= ?, telefono= ?, type_id= ? WHERE document= ?";
            int pos = 0;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(++pos, employee.getFullname());
            preparedStatement.setString(++pos, employee.getAddres());
            preparedStatement.setString(++pos, employee.getPhone());
            preparedStatement.setInt(++pos, employee.getEmployeeType().getId());//Llave FK
            preparedStatement.setLong(++pos, employee.getDocument());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al actualizar tipo de llave"
                    + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public void delete(long document) {
        try {
            connect();
            String sql = "DELETE FROM employee WHERE document= ?";
            int pos = 0;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(++pos, document);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al eliminar tipo de llave"
                    + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public List<Employee> findall() {
        List<Employee> results = new ArrayList<>();
        DBEmployeeType dbet = new DBEmployeeType();
        try {
            connect();
            String sql = "SELECT * from employee";
            statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                Employee employee = new Employee();
                employee.setDocument(resultset.getLong("document"));
                employee.setFullname(resultset.getString("fullname"));
                employee.setAddres(resultset.getString("direccion"));
                employee.setPhone(resultset.getString("telefono"));
                //FK
                EmployeeType employeeType = dbet.findById(resultset.getInt("type_id"));
                employee.setEmployeeType(employeeType);
                results.add(employee);
            }
            resultset.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROr al realizar la consulta"
                    + e.getMessage());
        } finally {
            disconnect();
        }
        return results;
    }

    public Employee findById(long document) {
        Employee employee = null;
        DBEmployeeType dbet = new DBEmployeeType();

        try {
            connect();
            String sql = "SELECT * FROM employee WHERE document = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, document);
            ResultSet resultset = preparedStatement.executeQuery();
            // .next para recorrer todos los resultados
            if (resultset.next()) {
                employee = new Employee();
                employee.setDocument(resultset.getLong("document"));
                employee.setFullname(resultset.getString("fullname"));
                employee.setAddres(resultset.getString("direccion"));
                employee.setPhone(resultset.getString("telefono"));

                //FK
                EmployeeType employeeType = dbet.findById(resultset.getInt("type_id"));
                employee.setEmployeeType(employeeType);

            }
            resultset.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al consultar el tipo de empleado"
                    + e.getMessage());
        } finally {
            disconnect();
        }
        return employee;
    }
}
