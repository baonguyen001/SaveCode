package com.example.Practice.service;

import com.example.Practice.dto.MenuDTO;
import com.example.Practice.entity.Category;
import com.example.Practice.entity.Food;
import com.example.Practice.reponsitory.MenuReponsitory;
import com.example.Practice.service.imp.FileServiceImp;
import com.example.Practice.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MenuService implements MenuServiceImp {

    @Autowired
    MenuReponsitory menuReponsitory;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean insertMenu(MultipartFile file ,String title, boolean isFreeship, String timeShip, float prices, int cateId) {

        boolean isSucces = false;
        if(fileServiceImp.saveFile(file)){
            Food food = new Food();
            food.setTitle(title);
            food.setFreeShip(isFreeship);
            food.setTimeShip(timeShip);
            food.setPrices(prices);
            food.setImage(file.getOriginalFilename());

            Category category = new Category();
            category.setId(cateId);

            food.setCategory(category);

            menuReponsitory.save(food);
            isSucces = true;
        }

        return isSucces;
    }
}
