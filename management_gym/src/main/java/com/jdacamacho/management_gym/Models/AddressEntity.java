package com.jdacamacho.management_gym.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
public class AddressEntity {
    @Id
    private long idUser;
    private String street;
    private String city;
    private String country;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idUser")
    private UserEntity objUser;

    public AddressEntity(){
        
    }
}
