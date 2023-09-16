package com.example.Practice.service.imp;

import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImp {
    boolean insertMenu(MultipartFile file,
                        String title,
                       boolean isFreeship,
                       String timeShip,
                       float prices,
                       int cateId);
}
