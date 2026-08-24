package com.tausif.AdminMicroService.controller;


import com.tausif.AdminMicroService.entity.Admin;
import com.tausif.AdminMicroService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"/", "/home", "/index"})
    public String home(){
        return "Welcome to Admin MicroService";
    }

    @PostMapping("/adminRegister")
    public boolean adminRegister(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }

}
