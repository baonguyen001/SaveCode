package com.example.osahaneat.reponsitory;

import com.example.osahaneat.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantReponsitory extends JpaRepository<Restaurant, Integer> {

}
