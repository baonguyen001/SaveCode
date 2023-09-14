package com.example.osahaneat.controller;

import com.example.osahaneat.entity.Food;
import com.example.osahaneat.payload.ResponData;
import com.example.osahaneat.reponsitory.FoodReponsitory;
import com.example.osahaneat.service.imp.MenuFoodServiceImp;
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
    MenuFoodServiceImp menuFoodServiceImp;

    @GetMapping()
    public ResponseEntity<?> createMenuFood( @RequestParam MultipartFile file,
                                            @RequestParam String title,
                                            @RequestParam  boolean isFreeship,
                                            @RequestParam  String timeShip,
                                            @RequestParam  double prices,
                                            @RequestParam  int cateId){

        ResponData responData = new ResponData();
        responData.setData(menuFoodServiceImp.createMenu(file, title, isFreeship, timeShip, prices, cateId));

        return new ResponseEntity<>(responData, HttpStatus.OK);

    }

}
