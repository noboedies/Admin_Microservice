package com.tausif.AdminMicroService.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class Complaint {

    private Long id;
    private String username;
    private String title;
    private String description;
    private String category;
    private LocalDate incidentDate;
    private LocalDateTime createdAt;
    private String latitude;
    private String longitude;
    private String location;
    private String zipCode;
}
