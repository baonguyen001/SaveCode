package com.example.osahaneat.security;

import com.example.osahaneat.Utils.JwtUtilsHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

//                                 Mỗi request đều đi qua Filter
@Component
public class CustomJwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    String token = getTokenFromHeader(request);
    if(token != null){
        //Tạo chứng thực cho security
        if (jwtUtilsHelper.verifyToken(token)){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken("", "", new ArrayList<>());
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(usernamePasswordAuthenticationToken);
        }
    }
        //cho phép đi vào các link api
        filterChain.doFilter(request, response);
    }

    private String getTokenFromHeader(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        String token = null;

    /*  StringUtils.hasText(header) kiểm tra chuỗi header. Nếu chuỗi không rỗng và chứa ít nhất một ký tự
     không phải khoảng trắng trả về true, ngược lại sẽ trả về false.*/

        if(StringUtils.hasText(header) && header.startsWith("Bearer ")){
            //cắt chuỗi từ kí tự thứ 7
            token = header.substring(7);
        }
        return token;
    }
}
