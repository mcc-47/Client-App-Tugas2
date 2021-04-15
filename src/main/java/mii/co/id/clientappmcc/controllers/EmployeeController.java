/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.clientappmcc.controllers;

import java.util.List;
import mii.co.id.clientappmcc.models.Employee;
import mii.co.id.clientappmcc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jakab
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeContactService;
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("employees", employeeContactService.getAll());
        return "employee/employee";
    }
    
//    @GetMapping("/new")
//    public String form(){
//        return "employee-create";
//    }
    
    @GetMapping("/get-all")
    public @ResponseBody List<Employee> getAllProcess() {
        return employeeContactService.getAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody Employee getById(@PathVariable("id") Integer id) {
//        model.addAttribute("employees", employeeContactService.getById(id));
        return employeeContactService.getById(id);
    }
    
    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        employeeContactService.create(employee);
        return employee;
    }
    
    @PutMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        employeeContactService.update(id, employee);
        return "redirect:/employee";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeContactService.delete(id);
        return "redirect:/employee";
    }
    
}
