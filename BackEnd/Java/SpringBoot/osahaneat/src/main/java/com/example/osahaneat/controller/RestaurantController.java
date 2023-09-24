package com.example.osahaneat.controller;


import com.example.osahaneat.payload.ResponData;
import com.example.osahaneat.service.imp.FileServiceImp;
import com.example.osahaneat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    RestaurantServiceImp restaurantServiceImp;

    @PostMapping
    public ResponseEntity<?> createRestaurant(@RequestParam MultipartFile file,
                                              @RequestParam String title,
                                              @RequestParam String subtitle,
                                              @RequestParam String description,
                                              @RequestParam boolean isFreeship,
                                              @RequestParam String address,
                                              @RequestParam String openDate) {
        ResponData responData = new ResponData();
        responData.setData(restaurantServiceImp.insertRestaurant(file, title, subtitle, description, isFreeship, address, openDate));

        return new ResponseEntity<>(responData, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getHomeRestaurant() {
        ResponData responData = new ResponData();
        responData.setData(restaurantServiceImp.getHomePageRestaurant());

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

    @GetMapping("/details")
    public ResponseEntity<?> getDetailsRestaurant(@RequestParam int id) {
        ResponData responData = new ResponData();


        return new ResponseEntity<>(responData, HttpStatus.OK);
    }

}
