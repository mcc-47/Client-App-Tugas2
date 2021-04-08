/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dtos.UserLoginDTO;
import com.mii.server.dtos.UserSessionDTO;
import com.mii.server.repositories.UserRepository;
import com.mii.server.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author William Yangjaya
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @PostMapping("/login")
    public UserSessionDTO test(@RequestBody UserLoginDTO userLoginDTO) throws Exception {
        return myUserDetailsService.login(userLoginDTO);
    }

    @GetMapping
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping("/get")
    public String get() {
        return ("<h1>Ini Get</h1>");
    }

    @GetMapping("/getall")
    public String getAll() {
        return ("<h1>Ini GetAll</h1>");
    }

    @GetMapping("/post")
    public String post() {
        return ("<h1>Ini Post</h1>");
    }

    @GetMapping("/update")
    public String update() {
        return ("<h1>Ini Update</h1>");
    }

    @GetMapping("/delete")
    public String delete() {
        return ("<h1>Ini Delete</h1>");
    }

}
