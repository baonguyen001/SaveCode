package com.example.Practice.service;

import java.util.ArrayList;
import java.util.List;

import com.example.Practice.entity.Roles;
import com.example.Practice.payload.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Practice.dto.UserDTO;
import com.example.Practice.entity.Users;
import com.example.Practice.reponsitory.UserReponsitory;
import com.example.Practice.service.imp.UserServiceImp;

@Service
public class UserService implements UserServiceImp{
	
	@Autowired
	UserReponsitory reponsitory;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	List<Users> listUser = new ArrayList<Users>();

	@Override
	public List<UserDTO> getAllUser(){
		
		listUser = reponsitory.findAll();
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		
		for(Users user: listUser) {
			UserDTO userDTO = new UserDTO();
			
			userDTO.setUsername(user.getUserName());
			userDTO.setPassword(user.getPassword());
			userDTO.setFullname(user.getFullName());
			
			listUserDTO.add(userDTO);
		}
		
		return listUserDTO;
	}


	@Override
	public boolean checkLogin(String username, String password) {

		Users user = reponsitory.findUsersByUserName(username);

		return passwordEncoder.matches(password, user.getPassword());
	}

	@Override
	public boolean addUser(SignUpRequest signUpRequest) {

		Roles roles = new Roles();
		roles.setId(signUpRequest.getRoleId());

		Users users = new Users();
		users.setFullName(signUpRequest.getFullname());
		users.setUserName(signUpRequest.getUsername());
		users.setPassword(signUpRequest.getPassword());
		users.setRoles(roles);

		try {
			reponsitory.save(users);
			return true;
		}catch (Exception e){
			return false;
		}

	}



}
