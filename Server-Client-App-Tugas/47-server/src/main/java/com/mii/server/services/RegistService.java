/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.services;

import com.mii.server.dtos.RegistDTO;
import com.mii.server.entities.Address;
import com.mii.server.entities.Contact;
import com.mii.server.entities.Education;
import com.mii.server.entities.Employee;
import com.mii.server.entities.Major;
import com.mii.server.entities.Role;
import com.mii.server.entities.University;
import com.mii.server.entities.User;
import com.mii.server.entities.Village;
import com.mii.server.repositories.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Yangjaya
 */
@Service
public class RegistService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    public RegistService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee insertData(RegistDTO registDTO) {
        List<Role> role = new ArrayList<>();
        role.add(new Role("user"));
        
        Employee nreg = new Employee(
                registDTO.getEmployeeId(),
                registDTO.getEmployeeName(),
                registDTO.getBirthDate(),
                registDTO.getGender(),
                registDTO.getEmail(),
                new Address(registDTO.getEmployeeId(), new Village(registDTO.getVillageId())),
                new Education(registDTO.getEmployeeId(), new Major(registDTO.getMajorId()), new University(registDTO.getUniversityId())),
                new Contact(registDTO.getEmployeeId(),registDTO.getPhone(),registDTO.getLinkedin()),
                new User(registDTO.getEmployeeId(),registDTO.getUsername(),passwordEncoder.encode(registDTO.getPassword()), role)
        );
        return employeeRepository.save(nreg);
    }

}