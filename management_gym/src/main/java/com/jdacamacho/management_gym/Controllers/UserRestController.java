package com.jdacamacho.management_gym.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdacamacho.management_gym.Services.DTO.UserDTO;
import com.jdacamacho.management_gym.Services.Interfaces.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> index(){
        List<UserDTO> users = this.userService.listUsers();
        ResponseEntity<List<UserDTO>> objResponse = new ResponseEntity<List<UserDTO>>(users,HttpStatus.OK);
        return objResponse;
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserDTO> get(@PathVariable long idUser){
        UserDTO user = this.userService.findUserById(idUser);
        ResponseEntity<UserDTO> objResponse = new ResponseEntity<UserDTO>(user,HttpStatus.OK);
        return objResponse;
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO request){
        UserDTO user = this.userService.saveUser(request);
        ResponseEntity<UserDTO> objResponse = new ResponseEntity<UserDTO>(user,HttpStatus.CREATED);
        return objResponse;
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<UserDTO> update(@PathVariable long idUser,@RequestBody UserDTO request){
        UserDTO user = this.userService.updateUser(idUser, request);
        ResponseEntity<UserDTO> objResponse = new ResponseEntity<UserDTO>(user,HttpStatus.CREATED);
        return objResponse;
    }
}
