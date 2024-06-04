package com.jdacamacho.management_gym.Services.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlanDTO {
    private String name;
    private List<BenefitDTO> benefits;

    public PlanDTO(){
        this.benefits = new ArrayList<>();
    }
}
