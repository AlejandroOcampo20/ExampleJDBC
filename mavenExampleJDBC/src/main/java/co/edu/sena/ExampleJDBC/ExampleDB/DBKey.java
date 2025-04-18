/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.ExampleDB;

import co.edu.sena.ExampleJDBC.Utils.MessageUtils;
import co.edu.sena.ExampleJDBC.model.Key;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *  Date: 13/03/2025
 * @author alejo
 * Objetive: permite consultas/transaciones en la tabla key
 */
public class DBKey  extends  DBConnection{
    
    public void insert (Key key) {
        try {
                  connect();
                  String sql = "insert into `key` (id, name, room, count, observation) values (?, ?, ?, ?, ?)";
                  PreparedStatement preparedStatement = connection.prepareStatement(sql);
                  
                  preparedStatement.setInt(1, key.getId());
                  preparedStatement.setString(2, key.getName());
                  preparedStatement.setString(3, key.getRoom());
                  preparedStatement.setInt(4, key.getCount());
                  preparedStatement.setString(5, key.getObservation());
                  preparedStatement.executeUpdate();
                  preparedStatement.close();
        } catch (SQLException e) {
                  MessageUtils.ShowErrorMessage("ERROR al insertar el tipo de llave"
                  +e.getMessage());
        } finally {
            disconnect();
        }
    }
    
    public void update (Key key){
        try {
                  connect();
                  String sql = "update `Key` set name =?, room =?, count =?, observation = ? where id = ?";
                  PreparedStatement preparedStatement = connection.prepareStatement(sql);
                  
                  preparedStatement.setString(1, key.getName());
                  preparedStatement.setString(2, key.getRoom());
                  preparedStatement.setInt(3, key.getCount());
                  preparedStatement.setString(4, key.getObservation());
                  preparedStatement.setInt(5, key.getId());
                  preparedStatement.executeUpdate();
                  preparedStatement.close();
        } catch (SQLException e) {
                  MessageUtils.ShowErrorMessage("ERROR al actualizar tipo de llave"
                           +e.getMessage());
        } finally {
                  disconnect();
        }
    }
    
    public void delete(int id){
         try {
                  connect();
                  String sql = "delete from `Key` where id = ?";
                  PreparedStatement preparedStatement = connection.prepareStatement(sql);
                  preparedStatement.setInt(1, id);
                  preparedStatement.executeUpdate();
                  preparedStatement.close();
        } catch (SQLException e) {
                  MessageUtils.ShowErrorMessage("ERROR al eliminar tipo de llave"
                          +e.getMessage());
        } finally {
             disconnect();
        }
    }
    
    public  List<Key> findAll () {
        List<Key> results = new ArrayList<>();
        try {
                  connect();
                  String sql = "select * from `key`";
                  statement = connection.createStatement();
                  ResultSet resultSet = statement.executeQuery(sql);
                  
                  while(resultSet.next()){
                           Key key = new Key();
                           key.setId(resultSet.getInt("id"));
                           key.setName(resultSet.getString("name"));
                           key.setRoom(resultSet.getString("room"));
                           key.setCount(resultSet.getInt("count"));
                           key.setObservation(resultSet.getString("observation"));
                           results.add(key);
                  }
                  resultSet.close();
        } catch (SQLException e) {
                  MessageUtils.ShowErrorMessage("ERROR al realizar la consulta"
                           +e.getMessage());
        } finally {
                  disconnect();
        }
        return  results;
    }
    
    public  Key findById (int id){
         Key key = null;
         try {
                  connect();
                  String sql = "select * from `key` where id = ?";
                  PreparedStatement preparedStatement = connection.prepareStatement(sql);
                  preparedStatement.setInt(1, id);
                  ResultSet resultSet = preparedStatement.executeQuery();
                  
                  if (resultSet.next()){
                           key = new Key();
                           key.setId(resultSet.getInt("id"));
                           key.setName(resultSet.getString("name"));
                           key.setRoom(resultSet.getString("room"));
                           key.setCount(resultSet.getInt("count"));
                           key.setObservation(resultSet.getString("observation"));
                  }
                  resultSet.close();
                  preparedStatement.close();
        } catch (SQLException e) {
                 MessageUtils.ShowErrorMessage("ERROR al realizar la consulta " 
                           + e.getMessage());
        } finally {
             disconnect();
        }
         return key;
    }   
}
