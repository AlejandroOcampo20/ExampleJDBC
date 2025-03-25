/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Test;

import co.edu.sena.ExampleDB.DBEmployee;
import co.edu.sena.ExampleJDBC.ExampleDB.DBKey;
import co.edu.sena.ExampleDB.DBRecord;
import co.edu.sena.ExampleJDBC.model.Employee;
import co.edu.sena.ExampleJDBC.model.Key;
import co.edu.sena.ExampleJDBC.model.Record;
import java.util.List;

/**
 * Date:20/03/2025
 * @author alejo
 * Objetive: Probar consultas/transacciones en tabla record
 */
public class TestRecord {
    public static void main(String[] args) {
        
        DBRecord dbr= new DBRecord();
        DBEmployee dbe = new DBEmployee();
        DBKey dbk = new DBKey();
        Employee employee = dbe.findById(1115);
        Key key = dbk.findById(1);
        
        //insertar
        Record record = new Record(0, "2020-12-29", "7:20:00", null, employee, key, "PENDIENTE");
        //dbr.insert(record);
        
        
        //Actualizar
//        record = dbr.findById(4);
//        record.setEnd_time("18:00:00");
//        record.setStatus("Entregado");
//        dbr.update(record);

        //Eliminar 
        //dbr.delete(4);
        
        //buscar todos
        List<Record> records = dbr.findall();
        for (Record r : records) {
            System.out.println("id: " + r.getId() + " date_record: " + r.getDate_record() + " start_time: " + r.getStart_time()
               + " end_time: " + r.getEnd_time() + " employee_id: " + r.getEmployee_id() + " key_id: " + r.getKey_id()
                + " status: " + r.getStatus());
            
        }  
            System.out.println("******************************");
            
        Record record1 = dbr.findById(1);
        
            System.out.println("id: " + record1.getId() + " date_record: " + record1.getDate_record() + " start_time: " + record1.getStart_time()
               + " end_time: " + record1.getEnd_time() + " employee_id: " + record1.getEmployee_id() + " key_id: " + record1.getKey_id()
                + " status: " + record1.getStatus());
            
        
        
        
        
    }
}
