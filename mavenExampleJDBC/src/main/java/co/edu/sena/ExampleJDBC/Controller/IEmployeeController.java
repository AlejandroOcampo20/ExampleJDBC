/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Controller;

import co.edu.sena.ExampleJDBC.model.Employee;
import java.util.List;

/**
 *
 * @author alejo
 */
public interface IEmployeeController {
    public void insert(Employee employee) throws Exception;
    public void update(Employee employee) throws Exception;
    public void delete(long document) throws Exception;
    public List<Employee> findall() throws  Exception;
    public Employee findById(long document) throws Exception;
    
}
