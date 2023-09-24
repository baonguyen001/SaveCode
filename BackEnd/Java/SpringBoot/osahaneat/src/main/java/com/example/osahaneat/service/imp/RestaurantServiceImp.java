package com.example.osahaneat.service.imp;

import com.example.osahaneat.dto.RestaurantDTO;
import com.example.osahaneat.entity.Restaurant;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface RestaurantServiceImp {
    boolean insertRestaurant( MultipartFile file,
                              String title,
                              String subtitle,
                              String description,
                              boolean isFreeship,
                              String address,
                              String openDate);

    List<RestaurantDTO> getHomePageRestaurant();
    RestaurantDTO getDetailsRestaurant(int id);
}
