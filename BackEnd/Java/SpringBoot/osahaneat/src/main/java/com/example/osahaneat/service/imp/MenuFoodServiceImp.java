package com.example.osahaneat.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface MenuFoodServiceImp{
    boolean createMenu( MultipartFile file,
                            String title,
                             boolean isFreeship,
                             String timeShip,
                             double prices,
                             int cateId);
}
