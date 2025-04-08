/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Controller;

import co.edu.sena.ExampleJDBC.ExampleDB.DBKey;
import co.edu.sena.ExampleJDBC.model.Key;
import java.util.List;

/**
 Date: 25/03/2025
 * @author alejo
 */
public class KeyController implements IKeyController{
    private DBKey dbk = new DBKey();

    @Override
    public void insert(Key key) throws Exception {
        if (key.getId() == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        if ("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(key.getRoom()))
        {
            throw new Exception("La sala es obligatoria");
        }
        if (key.getCount() == 0)
        {
            throw new Exception("La cantidad es obligatoria");
        }
        if("".equals(key.getObservation()))
        {
            throw new Exception("La observación es obligatoria");
        }
        //Insertar
        dbk.insert(key);
    }

    @Override
    public void update(Key key) throws Exception {
        if (key.getId() == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        if ("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(key.getRoom()))
        {
            throw new Exception("La sala es obligatoria");
        }
        if (key.getCount() == 0)
        {
            throw new Exception("La cantidad es obligatoria");
        }
        if("".equals(key.getObservation()))
        {
            throw new Exception("La observación es obligatoria");
        }
        
        if (key == null)
        {
            throw new Exception("La llave no existe");
        }
        //Actualizar
        dbk.update(key);
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        Key keyExists = dbk.findById(id);
        if("".equals(keyExists.getName()))
        {
            throw new Exception("La llave no existe");
        }
    }

    @Override
    public List<Key> findAll() throws Exception {
        return dbk.findAll();
    }

    @Override
    public Key findById(int id) throws Exception {
        if (id == 0)
        {
            throw new Exception("El Id es obligatorio");
        }
        return dbk.findById(id);
    }
    
}
