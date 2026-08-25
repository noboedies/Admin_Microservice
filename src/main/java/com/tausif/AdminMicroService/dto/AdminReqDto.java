package com.tausif.AdminMicroService.dto;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminReqDto {

    private String email;
    private String name;
    private String username;
    private String password;
}
