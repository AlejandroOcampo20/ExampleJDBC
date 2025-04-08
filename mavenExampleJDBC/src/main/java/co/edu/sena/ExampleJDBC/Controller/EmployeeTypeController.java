/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Controller;

import co.edu.sena.ExampleJDBC.ExampleDB.DBEmployeeType;
import co.edu.sena.ExampleJDBC.model.EmployeeType;
import java.util.List;

/**
 * Date: 25/03/2025
 * @author alejo
 * Objetive: implementar la interface oara controlar el modelo employeeType
 */
public class EmployeeTypeController implements IEmployeeTypeController{

    private DBEmployeeType dbet = new DBEmployeeType();
    
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
        dbet.insert(employeeType);
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
        EmployeeType employeeTypeExists = dbet.findById(employeeType.getId());
        if (employeeTypeExists == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        //Actualizar
        dbet.update(employeeType); 
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        EmployeeType employeeTypeExists = dbet.findById(id);
        if (employeeTypeExists == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        
        //eliminar
        dbet.delete(id);
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
        return dbet.findAll();
    }

    @Override
    public EmployeeType findById(int Id) throws Exception {
        if (Id == 0) {
            throw new Exception("El id es obligatorio");
        }
        return dbet.findById(Id);
    
    }
    
}
