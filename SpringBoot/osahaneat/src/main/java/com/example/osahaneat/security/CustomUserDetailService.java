package com.example.osahaneat.security;

import com.example.osahaneat.entity.Users;
import com.example.osahaneat.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserReponsitory userReponsitory;


    // xác thực người dùng lấy thông tin từ database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userReponsitory.findByUserName(username);

        if(users == null){
            throw new UsernameNotFoundException("User can't exist");
        }

        //UserDetailsServiceAuthenticationToken
        return new User(username, users.getPassword(), new ArrayList<>());
    }
}
