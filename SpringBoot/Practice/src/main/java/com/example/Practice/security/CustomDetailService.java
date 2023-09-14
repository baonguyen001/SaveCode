package com.example.Practice.security;

import com.example.Practice.entity.Users;
import com.example.Practice.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomDetailService implements UserDetailsService {

    @Autowired
    UserReponsitory userReponsitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userReponsitory.findUsersByUserName(username);

        if(users == null){
            throw new UsernameNotFoundException("can't exits");
        }
//        System.out.println(username);

        return new User(username,
                users.getPassword(),
                new ArrayList<>());
    }
}
