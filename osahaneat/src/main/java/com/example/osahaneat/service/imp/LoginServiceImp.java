package com.example.osahaneat.service.imp;

import com.example.osahaneat.dto.UserDTO;
import com.example.osahaneat.payload.request.SignUpRequest;
import org.springframework.stereotype.Service;

import java.util.List;

//  Khử sự phụ thuộc
@Service
public interface LoginServiceImp {

    List<UserDTO> getAllUsers();
    boolean checkLogin(String username, String password);

    boolean addUser(SignUpRequest signUpRequest);


}
