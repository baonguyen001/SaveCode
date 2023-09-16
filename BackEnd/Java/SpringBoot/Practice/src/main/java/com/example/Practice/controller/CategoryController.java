package com.example.Practice.controller;


import com.example.Practice.payload.DataResponse;
import com.example.Practice.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @GetMapping()
    public ResponseEntity<?> getCategoryHome(){

        DataResponse dataResponse = new DataResponse();
        dataResponse.setData(categoryServiceImp.getCategoryHomePage());

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

}
