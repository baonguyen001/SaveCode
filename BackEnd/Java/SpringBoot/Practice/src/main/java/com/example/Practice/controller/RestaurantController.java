package com.example.Practice.controller;

import com.example.Practice.payload.DataResponse;
import com.example.Practice.service.imp.FileServiceImp;
import com.example.Practice.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin("*")
public class RestaurantController {
    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    RestaurantServiceImp restaurantServiceImp;

    @PostMapping()
    public ResponseEntity<?> createRestaurant(@RequestParam MultipartFile file,
                                              @RequestParam String title,
                                              @RequestParam String subtitle,
                                              @RequestParam String description,
                                              @RequestParam boolean isFreeship,
                                              @RequestParam String address,
                                              @RequestParam String openDate){
    DataResponse dataResponse = new DataResponse();
    dataResponse.setData(restaurantServiceImp.insertRestaurant(file, title, subtitle, description, isFreeship, address, openDate));

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }


    @PostMapping("/upload")
    public ResponseEntity<?> upLoadFile(@RequestParam MultipartFile file){
        DataResponse dataResponse = new DataResponse();
        dataResponse.setData(fileServiceImp.saveFile(file));
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
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
