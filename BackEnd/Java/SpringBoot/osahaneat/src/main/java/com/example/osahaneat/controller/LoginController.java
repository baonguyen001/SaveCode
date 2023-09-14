package com.example.osahaneat.controller;

import com.example.osahaneat.Utils.JwtUtilsHelper;
import com.example.osahaneat.payload.ResponData;
import com.example.osahaneat.payload.request.SignUpRequest;
import com.example.osahaneat.service.imp.LoginServiceImp;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Base64;

@RestController //Viết Api
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServiceImp loginServiceImp; //kích hoạt hàm trong implement. Những class nào sử dụng hàm trong Imp sẽ đc thực hiện code
    // Tương đương LoginServiceImp loginServiceImp = new LoginService();

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;

    //ResponseEntity<?> trả về 1 đối tượng "?" trả về kiểu dữ liệu bất kì
    @PostMapping("/signin")
    //@RequestParam : Nhận tham số trong phương thức post
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password){

        ResponData responData = new ResponData();
            if(loginServiceImp.checkLogin(username, password)){
                //Khi đăng nhập thành công sẽ sinh ra 1 token
                String token = jwtUtilsHelper.generateToken(username);
                responData.setData(token);
            }else {
                responData.setSuccess(false);
                responData.setData("");
            }

        return new ResponseEntity<>(responData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest){
        ResponData responData = new ResponData();

        responData.setData( loginServiceImp.addUser(signUpRequest));

        return new ResponseEntity<>(responData, HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUsers(){
        ResponData responData = new ResponData();

        responData.setData( loginServiceImp.getAllUsers());

        return new ResponseEntity<>(responData, HttpStatus.OK);
    }



}
