package com.jdacamacho.management_gym.Gateway.Interfaces;

import java.util.List;

import com.jdacamacho.management_gym.Services.DTO.PlanDTO;
import com.jdacamacho.management_gym.Services.DTO.UserDTO;

public interface IUserGateway {
    public List<UserDTO> findAll();
    public UserDTO save(UserDTO user);
    public UserDTO findById(long idUser);
    public boolean existsById(long idUser);
    public List<PlanDTO> findAllPlans();
}
