/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.RegistDTO;
import com.mii.server.entities.Employee;
import com.mii.server.services.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William Yangjaya
 */
@RequestMapping("/api")
@RestController
public class RegistrationController {

    @Autowired
    private RegistService registService;

    @PostMapping("/registration")
    public ResponseEntity<Employee> saveUser(@RequestBody RegistDTO registDTO) {
        return new ResponseEntity<>(registService.insertData(registDTO), HttpStatus.OK);
    }

    /*
    {
    "employeeId": 16,
    "employeeName": "mcc472021",
    "birthDate": "2021-05-05",
    "gender": "Laki-laki",
    "email": "mcc472021@gmail.com",
    "phone": "08472021",
    "linkedin": "mcc472021",
    "villageId": 11,
    "majorId": 1,
    "universityId": 8,
    "username": "mcc",
    "password": "mcc"
    }
    */
    /*
    {
    "employeeId": 17,
    "employeeName": "merdeka",
    "birthDate": "2021-03-03",
    "gender": "Laki-laki",
    "email": "mcc170845@gmail.com",
    "phone": "08170845",
    "linkedin": "mcc170845",
    "villageId": 11,
    "majorId": 1,
    "universityId": 8,
    "username": "merdeka",
    "password": "merdeka"
    }
    */
}