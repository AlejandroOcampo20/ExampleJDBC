/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Controller;

import co.edu.sena.ExampleJDBC.ExampleDB.DBEmployee;
import co.edu.sena.ExampleJDBC.model.Employee;
import java.util.List;

/**
 *
 * @author alejo
 */
public class EmployeeController implements IEmployeeController{

    private DBEmployee dbe = new DBEmployee();
    
    @Override
    public void insert(Employee employee) throws Exception {
        
        if (employee == null)
        {
            throw new Exception("El empleado es  nulo");
        }
        if (employee.getDocument() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        if ("".equals(employee.getFullname()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(employee.getAddres()))
        {
            throw new Exception("La dirección es obligatoria");
        }
        if ("".equals(employee.getPhone()))
        {
            throw new Exception("El telefono es obligatorio");
        }
        
        //FK
        if(employee.getEmployeeType() == null)
        {
            throw new Exception("El tipo de empleado es obligatorio");
        }
        //La Pk no es autoincremental, se debe validar existencia del empleado
        Employee employeeExists =dbe.findById(employee.getDocument());
        if (employeeExists != null)
        {
            throw new Exception("Ya existe un empleado con ese documento");
        }
        //Insertar
        dbe.insert(employee);
        
    }

    @Override
    public void update(Employee employee) throws Exception {
           if (employee == null)
        {
            throw new Exception("El empleado es  nulo");
        }
        if (employee.getDocument() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        if ("".equals(employee.getFullname()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(employee.getAddres()))
        {
            throw new Exception("La dirección es obligatoria");
        }
        if ("".equals(employee.getPhone()))
        {
            throw new Exception("El telefono es obligatorio");
        }
        
        //FK
        if(employee.getEmployeeType() == null)
        {
            throw new Exception("El tipo de empleado es obligatorio");
        }
        
        //Consultar si el employee existe en la DB
        if (employee == null)
        {
            throw new Exception("El tipo de empleado no existe");
        }
        //Actualizar
        dbe.update(employee);
    }

    @Override
    public void delete(long document) throws Exception {
        if(document == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        Employee employeeExists = dbe.findById(document);
        if(employeeExists == null)
        {
            throw new Exception("El empleado no existe");
        }
        
        //Eliminar
        dbe.findById(document);
    }

    @Override
    public List<Employee> findall() throws Exception {
        return dbe.findall();
    }

    @Override
    public Employee findById(long document) throws Exception {
        if (document == 0)
        {
            throw new Exception("El documento es obliagatorio");
        }
        return dbe.findById(document);
    }
    
}
