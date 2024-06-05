package com.jdacamacho.management_gym.Services.Implementations;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jdacamacho.management_gym.Exceptions.OwnException.BusinessRuleException;
import com.jdacamacho.management_gym.Exceptions.OwnException.EntityNotFoundException;
import com.jdacamacho.management_gym.Exceptions.OwnException.NoDataException;
import com.jdacamacho.management_gym.Gateway.Interfaces.IUserGateway;
import com.jdacamacho.management_gym.Services.DTO.UserDTO;
import com.jdacamacho.management_gym.Services.Interfaces.IUserService;

@Service
public class UserService implements IUserService{
    private final IUserGateway gateway;

    public UserService(IUserGateway gateway){
        this.gateway = gateway;
    }

    @Override
    public List<UserDTO> listUsers() {
        List<UserDTO> users = this.gateway.findAll();
        if(users.isEmpty()){
            throw new NoDataException("There are no users in the system");
        }
        return users;
    }

    @Override
    public UserDTO saveUser(UserDTO user) {
        if(user.userPlansHaveDuplicated()){
            throw new BusinessRuleException("user has duplicate plans");
        }
        if(!user.userPlansAreValid(this.gateway.findAllPlans())){
            throw new BusinessRuleException("plans are not valid");
        }
        user.setCreateAt(new Date());
        UserDTO userSaved = this.gateway.save(user);
        return userSaved;
    }

    @Override
    public UserDTO updateUser(long idUser, UserDTO user) {
        UserDTO oldUser = null;
        if(!this.gateway.existsById(idUser)){
            throw new EntityNotFoundException("User was not found");
        }
        if(user.userPlansHaveDuplicated()){
            throw new BusinessRuleException("user has duplicate plans");
        }
        if(!user.userPlansAreValid(this.gateway.findAllPlans())){
            throw new BusinessRuleException("plans are not valid");
        }
        oldUser = this.gateway.findById(idUser);
        oldUser.update(user);
        return this.gateway.save(oldUser);
    }

    @Override
    public UserDTO findUserById(long idUser) {
        if(!this.gateway.existsById(idUser)){
            throw new EntityNotFoundException("User was not found");
        }
        return this.gateway.findById(idUser);
    }

    
}
