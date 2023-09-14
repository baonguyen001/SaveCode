package com.example.osahaneat.service;

import com.example.osahaneat.dto.UserDTO;
import com.example.osahaneat.entity.Roles;
import com.example.osahaneat.entity.Users;
import com.example.osahaneat.payload.request.SignUpRequest;
import com.example.osahaneat.reponsitory.UserReponsitory;
import com.example.osahaneat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //Đưa lên IOC @Service: tác dụng đánh dấu đây là class xử lý logic code
public class LoginService implements LoginServiceImp {


    //Lấy Class từ IOC để sử dụng
    //khi trên IOC chỉ có 1 class, nếu > 2 Sử dụng @Qualifier("tên bean")
    @Autowired
    UserReponsitory userReponsitory;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUsers(){

        //Câu query
        List<Users> listUser =  userReponsitory.findAll(); //Lấy danh sách users trong database
        //Tránh lỗi vòng lặp vô tận
        List<UserDTO> listUserDTO = new ArrayList<>();

        //Gán ngược lại vào trong list
        for(Users users: listUser){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setUserName(users.getUserName());
            userDTO.setPassword(users.getPassword());
            userDTO.setCreateDate(users.getCreateDate());

            listUserDTO.add(userDTO);
        }

     return listUserDTO;
    }

    @Override
    public boolean checkLogin(String username, String password) {

        Users user = userReponsitory.findByUserName(username);

        //So sánh password đã được mã hóa ở database và password người dùng nhập vào
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        Roles roles = new Roles();
        roles.setId(signUpRequest.getRoleId());

        Users users = new Users();
        users.setFullName(signUpRequest.getFullName());
        users.setUserName(signUpRequest.getUserName());
        users.setPassword(signUpRequest.getPassword());
        users.setRoles(roles);

        try {
            userReponsitory.save(users);
            return true;
        }catch (Exception e){
            return false;
        }

    }



}
