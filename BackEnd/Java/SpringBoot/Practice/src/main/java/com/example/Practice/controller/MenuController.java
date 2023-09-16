package com.example.Practice.controller;


import com.example.Practice.payload.DataResponse;
import com.example.Practice.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuServiceImp menuServiceImp;

    @GetMapping()
    public ResponseEntity<?> createMenuFood(@RequestParam MultipartFile file ,
                                            @RequestParam String title,
                                            @RequestParam boolean isFreeship,
                                            @RequestParam String timeShip,
                                            @RequestParam float prices,
                                            @RequestParam int cateId){
        DataResponse dataResponse = new DataResponse();
        dataResponse.setData(menuServiceImp.insertMenu(file, title, isFreeship, timeShip, prices, cateId));

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }


}
