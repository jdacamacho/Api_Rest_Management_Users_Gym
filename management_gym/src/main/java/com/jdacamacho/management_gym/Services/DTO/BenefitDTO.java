package com.jdacamacho.management_gym.Services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BenefitDTO {
    private String name;
    private String description;

    public BenefitDTO(){

    }
}
