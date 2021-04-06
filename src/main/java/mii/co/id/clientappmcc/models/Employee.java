/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.models;

import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jakab
 */
@Data
public class Employee {
    
    private final String prefix = "MCC";
    private Integer employeeId;
    private String employeeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String gender;
    private String email;

    public Employee(Employee employeeContact) {
        this.employeeId = employeeContact.getEmployeeId();
        this.employeeName = employeeContact.getEmployeeName();
        this.birthDate = employeeContact.getBirthDate();
        this.gender = employeeContact.getGender();
        this.email = employeeContact.getEmail();
    }

    public Employee() {
    }
    
}
