package com.example.osahaneat.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface FileServiceImp {
//    MultipartFile hỗ trợ cơ chế stream (đọc và ghi file): tiết kiệm tài nguyên
    boolean saveFile(MultipartFile file);
    Resource loadFile(String file);
}
