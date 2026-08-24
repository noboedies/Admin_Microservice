package com.tausif.AdminMicroService.repository;

import com.tausif.AdminMicroService.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String> {

    Admin findByUsername(String email);
}
