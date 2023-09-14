package com.example.osahaneat.controller;


import com.example.osahaneat.payload.ResponData;
import com.example.osahaneat.service.imp.LoginServiceImp;
import com.example.osahaneat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUsers(){

        ResponData responData = new ResponData();
        responData.setData(userServiceImp.getAllUsers());

        return new ResponseEntity<>(responData, HttpStatus.OK);

    }

}
