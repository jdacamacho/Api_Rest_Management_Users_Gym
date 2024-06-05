package com.jdacamacho.management_gym.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "plans")
@Data
@AllArgsConstructor
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPlan;
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "plan_benefits",
        joinColumns = @JoinColumn(name = "idPlan"),
        inverseJoinColumns =  @JoinColumn(name = "idBenefit"))
    private List<BenefitsEntity> benefits;

    public PlanEntity(){
        this.benefits = new ArrayList<>();
    }
}
