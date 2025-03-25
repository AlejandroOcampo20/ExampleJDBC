/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Controller;

import co.edu.sena.ExampleDB.DBEmployeeType;
import co.edu.sena.ExampleJDBC.model.EmployeeType;
import java.util.List;

/**
 * Date: 25/03/2025
 * @author alejo
 * Objetive: implementar la interface oara controlar el modelo employeeType
 */
public class EmployeeTypeController implements IEmployeeTypeController{

    private DBEmployeeType dbe = new DBEmployeeType();
    
    @Override
    public void insert(EmployeeType employeeType) throws Exception {
        if (employeeType == null)
        {
            throw new Exception("El tipo de empleado es nulo");
        }
        if ("".equals(employeeType.getDescript()))
        {
            throw new Exception("La descripcion es obligatoria");
        }
        //Insertar
        dbe.insert(employeeType);
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        if (employeeType == null)
        {
            throw new Exception("El tipo de empleado es nulo");
        }
        if (employeeType.getId() == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        if ("".equals(employeeType.getDescript()))
        {
            throw new Exception("La descripcion es obligatoria");
        }
        
        //Consultar si el employeeType existe en la DB
        EmployeeType employeeTypeExists = dbe.findById(employeeType.getId());
        if (employeeTypeExists == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        //Actualizar
        dbe.update(employeeType); 
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        EmployeeType employeeTypeExists = dbe.findById(id);
        if (employeeTypeExists == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        
        //eliminar
        dbe.delete(id);
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
        return dbe.findAll();
    }

    @Override
    public EmployeeType findById(int Id) throws Exception {
        if (Id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return dbe.findById(Id);
    
    }
    
}
