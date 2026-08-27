package com.tausif.AdminMicroService.controller;


import com.tausif.AdminMicroService.dto.AdminReqDto;
import com.tausif.AdminMicroService.dto.AdminResDto;
import com.tausif.AdminMicroService.entity.Admin;
import com.tausif.AdminMicroService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<AdminResDto> adminRegister(@RequestBody AdminReqDto adminReqDto){
        AdminResDto adminResDto = adminService.createAdmin(adminReqDto);
        return ResponseEntity.ok(adminResDto);
    }

    @PostMapping("/login")
    public Admin login(@RequestParam String email, @RequestParam String password){
        Admin a = adminService.login(email, password);
        return a;
    }

}
