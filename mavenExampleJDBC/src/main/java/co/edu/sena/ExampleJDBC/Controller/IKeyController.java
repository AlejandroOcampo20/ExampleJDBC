/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Controller;

import co.edu.sena.ExampleJDBC.model.Key;
import java.util.List;

/**
 *Date: 25/03/2025
 * @author alejo
 */
public interface IKeyController {
    public void insert (Key key) throws Exception;
    public void update (Key key) throws Exception;
    public void delete(int id) throws Exception;
    public  List<Key> findAll () throws Exception;
    public  Key findById (int id) throws Exception;
    
}
