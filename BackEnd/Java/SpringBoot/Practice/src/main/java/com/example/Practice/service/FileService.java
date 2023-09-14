package com.example.Practice.service;

import com.example.Practice.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService implements FileServiceImp {

    @Value("${fileUpload.rootPath}")
    private String rootPath;
    private Path root;

    // khởi tạo một thư mục gốc (root) trong hệ thống tệp tin nếu nó chưa tồn tại
    @Override
    public void init() {
        try {
            root = Paths.get(rootPath);

            if(Files.notExists(root)){
                Files.createDirectories(root);
            }
        }catch (Exception e){
            System.out.println("Error create folder root : " + e.getMessage());
        }
    }

    @Override
    public boolean saveFile(MultipartFile file) {
        return false;
    }

    @Override
    public Resource loadFile(String fileName) {
        return null;
    }
}
