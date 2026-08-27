package com.tausif.AdminMicroService.service;


import com.tausif.AdminMicroService.dto.AdminReqDto;
import com.tausif.AdminMicroService.dto.AdminResDto;
import com.tausif.AdminMicroService.entity.Admin;
import com.tausif.AdminMicroService.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminService {


    @Autowired
    private AdminRepo adminRepo;

    public boolean saveAdmin(Admin admin) {

        Admin a = adminRepo.findById(admin.getEmail()).orElse(null);
        if(a == null){
            adminRepo.save(admin);
            return true;
        }else{
            return false;
        }
    }

    public Admin login(String email, String password) {

        Admin a = adminRepo.findById(email).orElse(null);
        if(a == null){
            a = adminRepo.findByUsername(email);
        }

        if(a == null){
            return null;
        }

        if(a.getPassword().equals(password)){
            return a;
        }
        return null;
    }

    public AdminResDto createAdmin(AdminReqDto adminReqDto) {

        Admin admin = adminRepo.findById(adminReqDto.getEmail()).orElse(null);
        if(admin != null){
            AdminResDto response = new AdminResDto();
            response.setMessage("User Already Exist!");
            return response;
        }
        Admin a = mapToEntity(adminReqDto);
        AdminResDto adminResDto = mapToDto(a);
        adminRepo.save(a);
        return adminResDto;
    }

    private Admin mapToEntity(AdminReqDto adminReqDto) {
        Admin admin = new Admin();
        admin.setEmail(adminReqDto.getEmail());
        admin.setName(adminReqDto.getName());
        admin.setUsername(adminReqDto.getUsername());
        admin.setPassword(adminReqDto.getPassword());
        admin.setCreatedAt(LocalDateTime.now());
        admin.setIsActive(true);
        return admin;
    }

    private AdminResDto mapToDto(Admin admin){
        AdminResDto adminResDto = new AdminResDto();
        adminResDto.setName(admin.getName());
        adminResDto.setEmail(admin.getEmail());
        adminResDto.setUsername(admin.getUsername());
        adminResDto.setMessage("User Created Successfully");
        return adminResDto;
    }
}
