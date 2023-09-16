package com.example.osahaneat.controller;

import com.example.osahaneat.payload.ResponData;
import com.example.osahaneat.service.imp.CategoryServiceImp;
import com.example.osahaneat.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @Autowired
    FileServiceImp fileServiceImp;

    @GetMapping()
    public ResponseEntity<?> getHomeRestaurant() {
        ResponData responData = new ResponData();
        responData.setData(categoryServiceImp.getCategoryHomePage());

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
