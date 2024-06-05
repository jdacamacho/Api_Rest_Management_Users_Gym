package com.jdacamacho.management_gym.Services.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private long idUser;
    private String name;
    private float height;
    private float weight;
    private Date createAt;
    private AddressDTO objAddress;
    private List<PlanDTO> plans;

    public UserDTO(){
        this.plans = new ArrayList<>();
    }

    public void update(UserDTO user){
        this.setName(user.getName());
        this.setHeight(user.getHeight());
        this.setWeight(user.getWeight());
        this.getObjAddress().setStreet(user.getObjAddress().getStreet());
        this.getObjAddress().setCity(user.getObjAddress().getCity());
        this.getObjAddress().setCountry(user.getObjAddress().getCountry());
        this.setPlans(user.getPlans());

    }
}
