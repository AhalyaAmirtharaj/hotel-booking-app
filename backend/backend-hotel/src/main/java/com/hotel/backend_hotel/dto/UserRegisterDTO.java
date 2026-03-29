package com.hotel.backend_hotel.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;

}
