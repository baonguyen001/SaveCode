package com.example.osahaneat.reponsitory;

import com.example.osahaneat.entity.Food;
import com.example.osahaneat.entity.MenuRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodReponsitory extends JpaRepository<Food, Integer> {
}
