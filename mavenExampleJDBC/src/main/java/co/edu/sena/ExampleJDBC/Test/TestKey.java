/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Test;

import co.edu.sena.ExampleJDBC.ExampleDB.DBKey;
import co.edu.sena.ExampleJDBC.model.Key;
import java.util.List;

/**
 * Date: 15/03/2025
 * @author alejo
 *  Objetive: probar consulta/transacciones en la taba key
 */
public class TestKey {
    public static void main(String[] args) {
        DBKey dBKey = new DBKey();
        //insertar
        Key key = new Key(0, "informatica 1", "Sala informatica 2", 4, "llave unica");
        //dBKey.insert(key);
        //Actualizar
        /*key.setId(4);
        key.setName("SST");
        key.setRoom("Ambiente 3");
        key.setCount(7);
        key.setObservation("Dos llaves");
        dBKey.update(key);*/
        //eliminar
        //dBKey.delete(2);
        //Consultar todos
        List<Key> listKey = dBKey.findAll();
        for (Key e : listKey) {
            System.out.println("id: " + e.getId() + "/ name: " + e.getName() + "/room: " + e.getRoom()
                  + "/count: " + e.getCount() + "/observation: " + e.getObservation());
        //Consultar por Id
        System.out.println("*************************************************************");
        Key key1 = dBKey.findById(4);
        if (key1 != null){
            System.out.println("id: " + e.getId() + "/ name: " + e.getName() + "/room: " + e.getRoom()
                  + "/count: " + e.getCount() + "/observation: " + e.getObservation());
        }
        else{
                  System.out.println("No exite la key con ese id");
        }
        }
    }
}
