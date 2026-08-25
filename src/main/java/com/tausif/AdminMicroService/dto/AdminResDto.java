package com.tausif.AdminMicroService.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResDto {

    private String email;
    private String name;
    private String username;
    private String message;
}
