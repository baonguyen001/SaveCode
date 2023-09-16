package com.example.Practice.service;

import com.example.Practice.dto.CategoryDTO;
import com.example.Practice.dto.MenuDTO;
import com.example.Practice.entity.Category;
import com.example.Practice.entity.Food;
import com.example.Practice.reponsitory.CategoryReponsitory;
import com.example.Practice.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    CategoryReponsitory categoryReponsitory;

    @Override
    public List<CategoryDTO> getCategoryHomePage() {
        List<CategoryDTO> listCategoryDTO = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("id"));
        Page<Category> listCategory =  categoryReponsitory.findAll(pageRequest);

        for (Category data: listCategory) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(data.getNameCate());

           List<MenuDTO> listMenuDTO = new ArrayList<>();
            for (Food dataFood: data.getListFoot()) {
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setTitle(dataFood.getTitle());
                menuDTO.setFreeship(dataFood.isFreeShip());
                menuDTO.setImage(dataFood.getImage());
                menuDTO.setPrices(dataFood.getPrices());
                menuDTO.setTimeShip(dataFood.getTimeShip());

                listMenuDTO.add(menuDTO);
            }
            categoryDTO.setMenus(listMenuDTO);

            listCategoryDTO.add(categoryDTO);

        }

        return listCategoryDTO;
    }
}
