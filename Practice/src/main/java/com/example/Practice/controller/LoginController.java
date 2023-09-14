package com.example.Practice.controller;

import com.example.Practice.Utils.JwtUtilsHelper;
import com.example.Practice.payload.request.SignUpRequest;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Practice.payload.DataResponse;
import com.example.Practice.service.imp.UserServiceImp;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {

	@Autowired
	UserServiceImp userServiceImp;

	@Autowired
	JwtUtilsHelper jwtUtilsHelper;


	//Lấy danh sách Users
	@PostMapping("/getAllUser")
	public ResponseEntity<?> getAllUser(){

		DataResponse dataResponse = new DataResponse();
		
		dataResponse.setData(userServiceImp.getAllUser());

		return new ResponseEntity<>(dataResponse, HttpStatus.OK);
	}

	@PostMapping("/getAllUser2")
	public ResponseEntity<?> getAllUsertest(){

		DataResponse dataResponse = new DataResponse();

		dataResponse.setData(userServiceImp.getAllUser());

		return new ResponseEntity<>(dataResponse, HttpStatus.OK);
	}



	//Đăng nhập nếu đúng xuất danh sách Users
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestParam String username, @RequestParam String password){
		DataResponse dataResponse = new DataResponse();
		if(userServiceImp.checkLogin(username, password)){
			String token = jwtUtilsHelper.genarateToken(username);
			dataResponse.setData(token);

		}else{
			dataResponse.setSucces(false);
			dataResponse.setData("");

		}

		return new ResponseEntity<>(dataResponse, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest){
		DataResponse dataResponse = new DataResponse();
		 dataResponse.setData(userServiceImp.addUser(signUpRequest));

		return new ResponseEntity<>(dataResponse, HttpStatus.OK);
	}

}
