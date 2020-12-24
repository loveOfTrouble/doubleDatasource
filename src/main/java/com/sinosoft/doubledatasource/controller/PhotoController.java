package com.sinosoft.doubledatasource.controller;

import com.sinosoft.doubledatasource.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping("/getCadreFilePhoto")
    public String getCadreFilePhoto() {
        photoService.synchronizeCadreFilePhoto();
        System.out.println("同步完成了");
        return "success";
    }
}
