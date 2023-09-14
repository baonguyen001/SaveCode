//Chứa code mang tính tái sử dụng
package com.example.osahaneat.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

//mang ý nghĩa tái sử dụng
@Component
public class JwtUtilsHelper {

    //Cho phép lấy giá trị đã lưu trong application.yml
    @Value("${jwt.privateKey}")
    private String privateKey;

    //Trả về Token            Truyền Dữ liệu cần mã hóa
    public String generateToken(String data){

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));

        //Sinh ra Token
        String jws = Jwts.builder().setSubject(data).signWith(key).compact();

        return jws;
    }

    //Giải mã
    public boolean verifyToken(String token){
    try {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return true;
    }catch (Exception e){
        return false;
    }
    }


}
