package com.example.Practice.service.imp;

import java.util.List;

import com.example.Practice.payload.request.SignUpRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Practice.dto.UserDTO;

@Service
public interface UserServiceImp {
	
	
	boolean checkLogin(String username, String password);
	List<UserDTO> getAllUser();
	boolean addUser(SignUpRequest signUpRequest);


}
