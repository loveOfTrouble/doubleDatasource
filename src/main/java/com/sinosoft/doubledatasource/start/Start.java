package com.sinosoft.doubledatasource.start;

import com.sinosoft.doubledatasource.service.PhotoService;
import com.sinosoft.doubledatasource.service.task.MaterialTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Start implements ApplicationRunner {

    @Autowired
    private MaterialTask materialTask;

    @Autowired
    private PhotoService photoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        materialTask.syncMaterial();

//        photoService.synchronizeCadreFilePhoto();
    }
}
