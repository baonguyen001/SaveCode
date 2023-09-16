package com.example.Practice.reponsitory;

import com.example.Practice.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuReponsitory extends JpaRepository<Food, Integer> {
}
