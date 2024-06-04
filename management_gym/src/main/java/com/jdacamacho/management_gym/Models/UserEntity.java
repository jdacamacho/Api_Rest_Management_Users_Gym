package com.jdacamacho.management_gym.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String name;
    private float height;
    private float weight;
    private Date createAt;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY ,mappedBy = "objUser")
    private AddressEntity objAddress;

    @ManyToMany(fetch =  FetchType.LAZY)
    @JoinTable(
        name = "user_plans",
        joinColumns = @JoinColumn(name = "idUser"),
        inverseJoinColumns =  @JoinColumn(name = "idPlan"))
    private List<PlanEntity> plans;

    public UserEntity(){
        this.plans = new ArrayList<>();
    }

}
