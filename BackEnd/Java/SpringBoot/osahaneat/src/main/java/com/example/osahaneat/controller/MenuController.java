package com.example.osahaneat.controller;

import com.example.osahaneat.entity.Food;
import com.example.osahaneat.payload.ResponData;
import com.example.osahaneat.reponsitory.FoodReponsitory;
import com.example.osahaneat.service.imp.FileServiceImp;
import com.example.osahaneat.service.imp.MenuFoodServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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

    @Autowired
    FileServiceImp fileServiceImp;

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
    @GetMapping("/file/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename) {

        Resource resource = fileServiceImp.loadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

}
