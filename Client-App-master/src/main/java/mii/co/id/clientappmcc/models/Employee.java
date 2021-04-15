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
 * @author Fadel
 */
@Data
public class Employee {
    
    private Integer employeeId;
    private String employeeName;
    private Date birthDate;
    private String gender;
    private String email;

    public Employee(Employee employee) {
        this.employeeId = employee.getEmployeeId();
        this.employeeName = employee.getEmployeeName();
        this.birthDate = employee.getBirthDate();
        this.gender = employee.getGender();
        this.email = employee.getEmail();
    }

    public Employee() {
    }
    
    
}
