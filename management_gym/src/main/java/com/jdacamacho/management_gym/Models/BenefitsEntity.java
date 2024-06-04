package com.jdacamacho.management_gym.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "benefits")
@Data
@AllArgsConstructor
public class BenefitsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBenefit;
    private String name;
    private String description;

    public BenefitsEntity(){

    }
}
