package com.example.osahaneat.service;

import com.example.osahaneat.entity.Category;
import com.example.osahaneat.entity.Food;
import com.example.osahaneat.entity.Restaurant;
import com.example.osahaneat.reponsitory.FoodReponsitory;
import com.example.osahaneat.service.imp.FileServiceImp;
import com.example.osahaneat.service.imp.MenuFoodServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MenuFoodService implements MenuFoodServiceImp {

    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    FoodReponsitory foodReponsitory;

    @Override
    public boolean createMenu(MultipartFile file, String title, boolean isFreeship, String timeShip, double prices, int cateId) {
        boolean insertIsSucces = false;

        try {
            boolean isSucces = fileServiceImp.saveFile(file);
            if(isSucces){
                Food food = new Food();
                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setFreeShip(isFreeship);
                food.setTimeShip(timeShip);
                food.setPrices((float) prices);

                Category category = new Category();
                category.setId(cateId);

                food.setCategory(category);

                foodReponsitory.save(food);


                insertIsSucces = true;
            }
        }catch (Exception e){
            System.out.println("Error insert restaurant: " + e.getMessage());
        }
        return insertIsSucces;
    }
}
