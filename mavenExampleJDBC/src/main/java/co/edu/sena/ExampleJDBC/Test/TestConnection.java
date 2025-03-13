/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Test;

import co.edu.sena.ExampleDB.DBConnection;

/**
 * 13/03/2025
 * @author alejo
 * Objetive: probar a conexio a la base de datos
 */
public class TestConnection {
    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.disconnect();
    }
}
