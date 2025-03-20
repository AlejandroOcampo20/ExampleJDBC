/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Test;

import co.edu.sena.ExampleDB.DBEmployee;
import co.edu.sena.ExampleDB.DBEmployeeType;
import co.edu.sena.ExampleJDBC.model.Employee;
import co.edu.sena.ExampleJDBC.model.EmployeeType;
import java.util.List;

/**
 *  Date:20/03/2025
 * @author alejo
 * Objetive: Probar consultas/transacciones en tabla employee
 */
public class TestEmployee {
    public static void main(String[] args) {
        DBEmployee dbe = new DBEmployee();
        DBEmployeeType dbet = new DBEmployeeType();
        //Insertar
        EmployeeType employeeType = dbet.findById(1);
        Employee employee = new Employee(521625856, "Elsa broson", "Av sa", "32395", employeeType);
        //dbe.insert(employee);
        
        //Actualizar
        /*employee.setFullname("Elba jon");
        employeeType = dbet.findById(2); //FK
        employee.setEmployeeType(employeeType);
        dbe.update(employee);*/
        //Eliminar
        //dbe.delete(521625856);
        //Buscar todos
        List<Employee> employees = dbe.findall();
        for (Employee e : employees) {
            System.out.println("document: " + e.getDocument() + " fullname: " + e.getFullname() + "addres: " 
                    + e.getAddres() + "phone: " + e.getPhone() + "type: " + e.getEmployeeType().getDescript());  
        }
        
        System.out.println("**************************************************************");
        Employee employee2 =  dbe.findById(1118);
        System.out.println("Document: " + employee2.getDocument() + 
                             " / fullname: " + employee2.getFullname()+ 
                                " / address: " + employee2.getAddres()+ 
                                " / phone: " + employee2.getPhone() + 
                                "  type: " + employee2.getEmployeeType().getDescript());

    }
}
