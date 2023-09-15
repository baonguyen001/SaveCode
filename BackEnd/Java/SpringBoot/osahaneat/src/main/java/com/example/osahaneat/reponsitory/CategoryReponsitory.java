package com.example.osahaneat.reponsitory;

import com.example.osahaneat.entity.Category;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReponsitory extends JpaRepository<Category, Integer> {
}
