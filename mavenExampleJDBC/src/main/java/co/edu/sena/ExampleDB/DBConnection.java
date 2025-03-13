/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleDB;

import co.edu.sena.ExampleJDBC.Utils.MessageUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Date: 13/03/2025
 * @author alejo
 * Objetive: Clade principal para conexion a dabe de datos
 */
public class DBConnection {
    public static Connection connection;
    public static Statement statement;
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB = "bdkeys";
    private final String USER = "root";
    private final String PASSWORD = "root";
    
    public void connect(){
        try {
              Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
              connection = DriverManager.getConnection("jdbc:mysql://" +HOST+ ":" +PORT+ "/" +DB, USER, PASSWORD);
              statement = connection.createStatement();
              System.out.println("Conectado");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            MessageUtils.ShowErrorMessage("Error de conexion a la base de datos");
        }
    }
    
    public void disconnect(){
        try {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
            System.out.println("Desconectado");
        } catch (SQLException e) {
            MessageUtils.ShowErrorMessage("Error desconectandose a la base de datos");
        }
    }
}
