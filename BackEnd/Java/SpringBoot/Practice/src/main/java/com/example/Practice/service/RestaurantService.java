package com.example.Practice.service;

import com.example.Practice.dto.RestaurantDTO;
import com.example.Practice.entity.Restaurant;
import com.example.Practice.reponsitory.RestaurantReponsitory;
import com.example.Practice.service.imp.FileServiceImp;
import com.example.Practice.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RestaurantService implements RestaurantServiceImp {

    @Autowired
    RestaurantReponsitory restaurantReponsitory;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description, boolean isFreeship, String address, String openDate) {

        boolean isSucces = false;

        try {
            if (fileServiceImp.saveFile(file)){
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setDescription(description);
                restaurant.setFreeship(isFreeship);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setAddress(address);
                restaurant.setSubtitle(subtitle);

                //chuyển đổi từ string sang date hoặc ngược lại theo định dạng tự quy định
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
                Date dateOpenDate = simpleDateFormat.parse(openDate);
                restaurant.setOpenDate(dateOpenDate);

                isSucces = true;
                restaurantReponsitory.save(restaurant);
            }
        }catch (Exception e){
            System.out.println("Error insert restaurant: " + e.getMessage());
        }
        return isSucces;
    }
}
