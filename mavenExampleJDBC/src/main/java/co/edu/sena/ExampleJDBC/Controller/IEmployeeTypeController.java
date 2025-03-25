/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Controller;

import co.edu.sena.ExampleJDBC.model.EmployeeType;
import java.util.List;

/**
 *
 * @author alejo
 */
public interface IEmployeeTypeController {
     public void insert (EmployeeType employeeType) throws Exception;
     public void update (EmployeeType employeeType)throws Exception;
     public void delete(int id)throws Exception;
     public List<EmployeeType> findAll () throws Exception;
     public EmployeeType findById (int Id) throws Exception;
     
}
