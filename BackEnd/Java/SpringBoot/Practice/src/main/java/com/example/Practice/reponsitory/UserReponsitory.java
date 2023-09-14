package com.example.Practice.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Practice.entity.Users;

@Repository
public interface UserReponsitory extends JpaRepository<Users, Integer> {

    Users findUsersByUserNameAndPassword(String username, String password);
    Users findUsersByUserName(String username);

	 
}
