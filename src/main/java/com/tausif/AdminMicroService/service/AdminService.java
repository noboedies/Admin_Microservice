package com.tausif.AdminMicroService.service;


import com.tausif.AdminMicroService.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    @Autowired
    private AdminRepo adminRepo;
}
