package com.tausif.AdminMicroService.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Data
@Entity
public class Admin {


    @Id
    private String email;
    private String name;
    private String username;
    private String password;
//    @CreationTimestamp
    private LocalDateTime createdAt;
    private Boolean isActive;

}
