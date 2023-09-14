package com.example.osahaneat.service;

import com.example.osahaneat.dto.UserDTO;
import com.example.osahaneat.entity.Users;
import com.example.osahaneat.reponsitory.UserReponsitory;
import com.example.osahaneat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    UserReponsitory userReponsitory;

    @Override
    public List<UserDTO> getAllUsers(){

        List<Users> list = userReponsitory.findAll();

        //Tránh lỗi vòng lặp vô tận
        List<UserDTO> listUserDTO = new ArrayList<>();

        //Gán ngược lại vào trong list
        for(Users users: list){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setUserName(users.getUserName());
            userDTO.setPassword(users.getPassword());
            userDTO.setCreateDate(users.getCreateDate());

            listUserDTO.add(userDTO);
        }

        return listUserDTO;
    }

}
