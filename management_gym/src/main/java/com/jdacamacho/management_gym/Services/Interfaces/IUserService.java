package com.jdacamacho.management_gym.Services.Interfaces;

import java.util.List;

import com.jdacamacho.management_gym.Services.DTO.UserDTO;

public interface IUserService {
    public List<UserDTO> listUsers();
    public UserDTO saveUser(UserDTO user);
    public UserDTO updateUser(long idUser,UserDTO user);
    public UserDTO findUserById(long idUser);
}
