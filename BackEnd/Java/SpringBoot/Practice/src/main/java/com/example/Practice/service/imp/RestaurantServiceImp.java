package com.example.Practice.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


public interface RestaurantServiceImp {
    boolean insertRestaurant(MultipartFile file,
                             String title,
                             String subtitle,
                             String description,
                             boolean isFreeship,
                             String address,
                             String openDate);
}
