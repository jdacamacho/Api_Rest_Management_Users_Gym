package com.jdacamacho.management_gym.Services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private String street;
    private String city;
    private String country;

    public AddressDTO(){

    }
}
