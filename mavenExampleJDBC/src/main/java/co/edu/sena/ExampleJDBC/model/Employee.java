/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.model;

/**
 * Date:20/03/2025
 * @author alejo
 * Objetive: representa la tabla employee
 */
public class Employee {
        private long document;
        private String fullname;
        private String addres;
        private String phone;
        private EmployeeType employeeType;

         public Employee() {
        }

        public Employee(long document, String fullname, String addres, String phone, EmployeeType employeeType) {
            this.document = document;
            this.fullname = fullname;
            this.addres = addres;
            this.phone = phone;
            this.employeeType = employeeType;
        }

        public long getDocument() {
            return document;
        }

        public void setDocument(long document) {
            this.document = document;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getAddres() {
            return addres;
        }

        public void setAddres(String addres) {
            this.addres = addres;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public EmployeeType getEmployeeType() {
            return employeeType;
        }

        public void setEmployeeType(EmployeeType employeeType) {
            this.employeeType = employeeType;
        }
        
         
        
}
