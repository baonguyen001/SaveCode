package com.example.osahaneat.service;

import com.example.osahaneat.dto.CategoryDTO;
import com.example.osahaneat.dto.MenuDTO;
import com.example.osahaneat.entity.Category;
import com.example.osahaneat.entity.Food;
import com.example.osahaneat.reponsitory.CategoryReponsitory;
import com.example.osahaneat.service.imp.CategoryServiceImp;
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
        //Chỉ lấy 2 Category ở trang 0  trong CSDL sắp xếp theo id
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("id"));
        Page<Category> listCategory = categoryReponsitory.findAll(pageRequest);

        List<CategoryDTO> listCategoryDTO = new ArrayList<>();

        for (Category cate:listCategory) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(cate.getNameCate());

            List<MenuDTO> menuDTOS = new ArrayList<>();

            for (Food food :cate.getListFoot()) {
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setTitle(food.getTitle());
                menuDTO.setFreeship(food.isFreeShip());
                menuDTO.setImage(food.getImage());

                menuDTOS.add(menuDTO);
            }
            categoryDTO.setMenus(menuDTOS);
            listCategoryDTO.add(categoryDTO);
        }

        return listCategoryDTO;
    }
}
