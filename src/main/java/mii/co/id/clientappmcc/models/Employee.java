/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.models;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author ROG
 */
@Data
public class Employee {
    private String employeeId;
    private String employeeName;
    private Date birthDate;
    private String gender;
    private String address;

    public Employee() {
    }

    public Employee(Employee e) {
        this.employeeId = e.employeeId;
        this.employeeName = e.employeeName;
        this.birthDate = e.getBirthDate();
        this.gender = e.gender;
        this.address = e.address;
    }
    
    
    
    
}
