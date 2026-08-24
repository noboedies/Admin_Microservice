package com.tausif.AdminMicroService.service;


import com.tausif.AdminMicroService.entity.Admin;
import com.tausif.AdminMicroService.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
