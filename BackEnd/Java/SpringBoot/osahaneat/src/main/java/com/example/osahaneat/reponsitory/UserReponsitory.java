package com.example.osahaneat.reponsitory;

import com.example.osahaneat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

//  IOC (container) : nơi lưu trữ các class được khởi tạo sẵn và có sẵn giá trị
//  @Bean đưa class được chỉ định lên IOC (container)

//   @Service = @Component = @Repository = @Bean :  chỉ khác nhau về tên

//  @Autowired : lấy class trên IOC để sử dụng
//  Không chỉ định tên bean thì tên bean chính là tên interface: "UserInterface"
@Repository
public interface UserReponsitory extends JpaRepository<Users, Integer> {

    //select * users where username = '' and password = ''

    List<Users> findByUserNameAndPassword(String username, String password);
    Users findByUserName(String username);
    

}
