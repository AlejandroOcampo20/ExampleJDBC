/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.model;

/**
 * Date: 20/03/2025
 *
 * @author alejo Objetive: representa la tabla Record
 */
public class Record {

    private int id;
    private String date_record;
    private String start_time;
    private String end_time;
    private Employee employee_id;
    private Key key_id;
    private String status;

    public Record() {
    }

    public Record(int id, String date_record, String start_time, String end_time, Employee employee_id, Key key_id, String status) {
        this.id = id;
        this.date_record = date_record;
        this.start_time = start_time;
        this.end_time = end_time;
        this.employee_id = employee_id;
        this.key_id = key_id;
        this.status = status;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_record() {
        return date_record;
    }

    public void setDate_record(String date_record) {
        this.date_record = date_record;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public Key getKey_id() {
        return key_id;
    }

    public void setKey_id(Key key_id) {
        this.key_id = key_id;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDateRecord(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setStartTime(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
