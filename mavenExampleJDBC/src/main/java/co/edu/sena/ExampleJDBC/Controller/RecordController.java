/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Controller;

import co.edu.sena.ExampleJDBC.ExampleDB.DBRecord;
import co.edu.sena.ExampleJDBC.model.Record;
import java.util.List;

/**
 * Date: 25/03/2025
 * @author alejo
 */
public class RecordController implements IRecordController{
    private DBRecord dbr = new DBRecord();

    @Override
    public void insert(Record record) throws Exception {
        if ("".equals(record.getDate_record())) {
            throw new Exception("La fecha de grabación es obligatorio");
        }
        if ("".equals(record.getStart_time())) {
            throw new Exception("El inicio de grabación es obligatorio");
        }
        //FK
        if (record.getEmployee_id()== null) {
            throw new Exception("El id de empleado es obligatorio");
        }
        if (record.getKey_id()== null) {
            throw new Exception("La id de llave es obligatoria");
        }
        if ("".equals(record.getStatus())) {
            throw new Exception("El status es obligatorio");
        }
        //La PK no es autoincremental, se debe validar existencia de la grabación
        Record recordExists = dbr.findById(record.getId());
        if (recordExists != null) {
            throw new Exception("Ya existe una grabación con ese documento");
        }
        
        dbr.insert(record);

    }

    @Override
    public void update(Record record) throws Exception {
        if (record == null) {
            throw new Exception("El empleado es nulo");
        }
        if(record.getId() == 0){
            throw new Exception("El id no puede ser 0");
        }
        if ("".equals(record.getDate_record())) {
            throw new Exception("La fecha de grabación es obligatorio");
        }
        if ("".equals(record.getStart_time())) {
            throw new Exception("El inicio de grabación es obligatorio");
        }
        if (record.getEmployee_id()== null) {
            throw new Exception("El id de empleado es obligatorio");
        }
        if (record.getKey_id()== null) {
            throw new Exception("La id de llave es obligatoria");
        }
        Record recordExists = dbr.findById(record.getId());
        if (recordExists != null) {
            throw new Exception("Ya existe una grabación con ese id");
        }
        if("".equals(record.getStatus())){
            throw new Exception("El status es obligatorio");
        }
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        Record recordExists = dbr.findById(id);
        if (recordExists == null) {
            throw new Exception("No existe un registro con ese id");
        }
        dbr.delete(id);

    }

    @Override
    public List<Record> findAll() throws Exception {
        return dbr.findall();
    }

    @Override
    public Record findById(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El id no puede ser 0");
        }
        return dbr.findById(id);
    }

}
