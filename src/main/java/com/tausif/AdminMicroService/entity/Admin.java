package com.tausif.AdminMicroService.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Admin {


    @Id
    private String email;
    private String name;
    private String username;
    private String password;

}
