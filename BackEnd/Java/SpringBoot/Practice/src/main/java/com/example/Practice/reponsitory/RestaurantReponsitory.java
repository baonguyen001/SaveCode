package com.example.Practice.reponsitory;

import com.example.Practice.entity.Restaurant;
import org.hibernate.query.criteria.JpaTupleElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantReponsitory extends JpaRepository<Restaurant, Integer> {
}
