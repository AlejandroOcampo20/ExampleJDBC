/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleDB;

import static co.edu.sena.ExampleDB.DBConnection.connection;
import static co.edu.sena.ExampleDB.DBConnection.statement;
import co.edu.sena.ExampleJDBC.ExampleDB.DBKey;
import co.edu.sena.ExampleJDBC.Utils.MessageUtils;
import co.edu.sena.ExampleJDBC.model.Employee;
import co.edu.sena.ExampleJDBC.model.Key;
import java.sql.PreparedStatement;
import co.edu.sena.ExampleJDBC.model.Record;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 20/03/2025
 *
 * @author alejo Objetive: permite consultas y transacciones en la tabla record
 */
public class DBRecord extends DBConnection {

    public void insert(Record record) {
        try {
            
            connect();
                String sql = "INSERT INTO record (id, date_record, start_time, end_time, employee_id, key_id, status)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int pos = 0;
            preparedStatement.setInt(++pos, record.getId());
            preparedStatement.setString(++pos, record.getDate_record());
            preparedStatement.setString(++pos, record.getStart_time());
            preparedStatement.setString(++pos, record.getEnd_time());
            preparedStatement.setLong(++pos, record.getEmployee_id().getDocument());
            preparedStatement.setInt(++pos, record.getKey_id().getId());
            preparedStatement.setString(++pos, record.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al insertar el tipo de record"
                    + e.getMessage());
        } finally {
            disconnect();
        }
    }
    
    public void update(Record record) {
        try {
           
            connect();
            String sql = "UPDATE record SET date_record= ?, start_time= ?, end_time= ?, employee_id= ?, key_id= ?, status= ? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int pos = 0;
            preparedStatement.setString(++pos, record.getDate_record());
            preparedStatement.setString(++pos, record.getStart_time());
            preparedStatement.setString(++pos, record.getEnd_time());
            preparedStatement.setLong(++pos, record.getEmployee_id().getDocument());//Llave FK
            preparedStatement.setInt(++pos, record.getKey_id().getId());//Llave FK
            preparedStatement.setString(++pos, record.getStatus());
            preparedStatement.setInt(++pos, record.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al actualizar el tipo de record "
                    + e.getMessage());
        } finally {
            disconnect();
        }
    }
    
    public void delete (int id){
        try {
            connect();
            String sql = "DELETE FROM record WHERE id= ?";
            int pos = 0;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(++pos, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al eliminar registro"
                    + e.getMessage());
        } finally {
            disconnect();
        }
    }
    
     public List<Record> findall() {
        List<Record> results = new ArrayList<>();
        DBEmployee dbe = new DBEmployee();
        DBKey dbk = new DBKey();
        try {
            connect();
            String sql = "SELECT * from record";
            statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                Record record = new Record();
                record.setId(resultset.getInt("id"));
                record.setDate_record(resultset.getString("date_record"));
                record.setStart_time(resultset.getString("start_time"));
                record.setEnd_time(resultset.getString("end_time"));
                //FK
                Employee employee = dbe.findById(resultset.getInt("employee_id"));
                Key key = dbk.findById(resultset.getInt("key_id"));
                record.setEmployee_id(employee);
                record.setKey_id(key);
                record.setStatus(resultset.getString("status"));
                results.add(record);
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

     public Record findById(int id) {
        Record record = null;
        DBEmployee dbe = new DBEmployee();
         DBKey dbk = new DBKey();

        try {
            connect();
            String sql = "SELECT * FROM record WHERE id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultset = preparedStatement.executeQuery();
            // .next para recorrer todos los resultados
            if (resultset.next()) {
                record = new Record();
                record.setId(resultset.getInt("id"));
                record.setDate_record(resultset.getString("date_record"));
                record.setStart_time(resultset.getString("start_time"));
                record.setEnd_time(resultset.getString("end_time"));

                //FK
                Employee employee = dbe.findById(resultset.getLong("employee_id"));
                Key key = dbk.findById(resultset.getInt("key_id"));
                record.setEmployee_id(employee);
                record.setKey_id(key);
                record.setStatus("status");

            }
            resultset.close();
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("ERROR al consultar el tipo de empleado"
                    + e.getMessage());
        } finally {
            disconnect();
        }
        return record;
    }
}
