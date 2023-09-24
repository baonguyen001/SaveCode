package com.example.osahaneat.service;

import com.example.osahaneat.dto.CategoryDTO;
import com.example.osahaneat.dto.MenuDTO;
import com.example.osahaneat.dto.RestaurantDTO;
import com.example.osahaneat.entity.*;
import com.example.osahaneat.reponsitory.RestaurantReponsitory;
import com.example.osahaneat.service.imp.FileServiceImp;
import com.example.osahaneat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@Service
public class RestaurantService implements RestaurantServiceImp {

    @Autowired
    RestaurantReponsitory restaurantReponsitory;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description, boolean isFreeship, String address, String openDate) {

        boolean insertIsSucces = false;

    try {
        boolean isSucces = fileServiceImp.saveFile(file);
        if(isSucces){
            Restaurant restaurant = new Restaurant();
            restaurant.setTitle(title);
            restaurant.setSubtitle(subtitle);
            restaurant.setDescription(description);
            restaurant.setImage(file.getOriginalFilename());
            restaurant.setFreeship(isFreeship);
            restaurant.setAddress(address);

//           chuyển đổi từ string sang date hoặc ngược lại theo định dạng tự quy định
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
            Date dateOpenDate = simpleDateFormat.parse(openDate);
            restaurant.setOpenDate(dateOpenDate);
            restaurantReponsitory.save(restaurant);

            insertIsSucces = true;
        }
    }catch (Exception e){
        System.out.println("Error insert restaurant: " + e.getMessage());
    }
        return insertIsSucces;
    }


    @Override
    public List<RestaurantDTO> getHomePageRestaurant() {
        List<RestaurantDTO> listRestaurantDTO = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0, 6);
        Page<Restaurant> listData =  restaurantReponsitory.findAll(pageRequest);

        for (Restaurant data: listData) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            RatingRestaurant ratingRestaurant = new RatingRestaurant();

            restaurantDTO.setImage(data.getImage());
            restaurantDTO.setTitle(data.getTitle());
            restaurantDTO.setFreeShip(data.getFreeship());
            restaurantDTO.setSubTitle(data.getSubtitle());
            restaurantDTO.setRating(caculatorRating(data.getListRatingRestaurants()));

            listRestaurantDTO.add(restaurantDTO);

        }

        return listRestaurantDTO;
    }

    @Override
    public RestaurantDTO getDetailsRestaurant(int id) {
        Optional<Restaurant> restaurant = restaurantReponsitory.findById(id);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        if(restaurant.isPresent()){
            List<CategoryDTO> listCategoryDTO = new ArrayList<>();


            restaurantDTO.setTitle(restaurant.get().getTitle());
            restaurantDTO.setSubTitle(restaurant.get().getSubtitle());
            restaurantDTO.setImage(restaurant.get().getImage());
            restaurantDTO.setRating(caculatorRating(restaurant.get().getListRatingRestaurants()));
            restaurantDTO.setFreeShip(restaurant.get().getFreeship());
            restaurantDTO.setOpenDate(restaurant.get().getOpenDate());

            for (MenuRestaurant data: restaurant.get().getListMenuRestaurants()) {
                List<MenuDTO> listMenuDTO = new ArrayList<>();
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setName(data.getCategory().getNameCate());

                for(Food food: data.getCategory().getListFoot()){
                    MenuDTO menuDTO = new MenuDTO();
                    menuDTO.setImage(food.getImage());
                    menuDTO.setTitle(food.getTitle());
                    menuDTO.setFreeship(food.isFreeShip());

                    listMenuDTO.add(menuDTO);
                }
                categoryDTO.setMenus(listMenuDTO);
                listCategoryDTO.add(categoryDTO);
            }
            restaurantDTO.setCategorys(listCategoryDTO);
        }
        return null;
    }

    private double caculatorRating(Set<RatingRestaurant> listRating){

        double totalpoin = 0;
        for (RatingRestaurant data: listRating) {
            totalpoin += data.getRatePoint();
        }
        return totalpoin/listRating.size();

    }
}
