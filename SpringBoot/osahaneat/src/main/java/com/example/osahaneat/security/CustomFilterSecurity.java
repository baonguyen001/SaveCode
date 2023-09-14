package com.example.osahaneat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //Khi spring boot start và ở tầng config thì phải đọc vào filter này và tương tác
@EnableWebSecurity
@EnableWebMvc
public class CustomFilterSecurity implements WebMvcConfigurer {

  @Autowired
  CustomUserDetailService customUserDetailService;

  @Autowired
  CustomJwtFilter customJwtFilter;

     //Mặc định là UserDetailService
    //Chỉ định sử dụng 'customUserDetailService'
  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception{
      AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
//AuthenticationManager biết cách lấy thông tin người dùng từ nguồn dữ liệu  |  để mã hóa mật khẩu khi xác thực.
      authenticationManagerBuilder.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());

      return  authenticationManagerBuilder.build();
  }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors()
                .and()
                .csrf()
                .disable()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
                .authorizeHttpRequests()
                .requestMatchers("/login/**", "/restaurant/file/**")
                .permitAll()
                .anyRequest()
                .authenticated();


//      Filter customJwtFilter sẽ được chạy trước UsernamePasswordAuthenticationFilter
        http.addFilterBefore(customJwtFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //or whichever methods you want to allow
                .allowedOrigins("*") //or www.example.com if you want to be more specific
                .allowedHeaders("Content_Type", "Authorization"); //i also put Authorization since i saw you probably want to do so
    }


}
