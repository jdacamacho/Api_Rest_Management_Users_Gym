package com.jdacamacho.management_gym.Gateway.Implementations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.jdacamacho.management_gym.Gateway.Interfaces.IUserGateway;
import com.jdacamacho.management_gym.Models.AddressEntity;
import com.jdacamacho.management_gym.Models.UserEntity;
import com.jdacamacho.management_gym.Repositories.UserRepository;
import com.jdacamacho.management_gym.Services.DTO.UserDTO;

@Service
public class UserGateway implements IUserGateway{
    private final UserRepository repository;
    private final ModelMapper mapper;

    public UserGateway(UserRepository repository, ModelMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UserDTO> findAll() {
        Iterable<UserEntity> data = this.repository.findAll();
        List<UserDTO> response = this.mapper.map(data, new TypeToken<List<UserDTO>>(){}.getType());
        return response;
    }

    @Override
    public UserDTO save(UserDTO user) {
        UserEntity userToSave = this.mapper.map(user, UserEntity.class);
        AddressEntity objAddress = userToSave.getObjAddress();
        objAddress.setObjUser(userToSave);
        UserEntity userSaved = this.repository.save(userToSave);
        UserDTO response = this.mapper.map(userSaved, UserDTO.class);
        return response;
    }

    @Override
    public UserDTO findById(long idUser) {
        UserEntity data = this.repository.findById(idUser).get();
        UserDTO response = this.mapper.map(data, UserDTO.class);
        return response;
    }

    @Override
    public boolean existsById(long idUser) {
        return this.repository.existsById(idUser);
    }
    
}
