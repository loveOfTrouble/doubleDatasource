package com.sinosoft.doubledatasource.controller;

import com.sinosoft.doubledatasource.service.task.MaterialTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author ASUS
 */
@RestController
@RequestMapping(value = "/archive")
public class ArchiveController {

    @Autowired
    MaterialTask materialTask;

    @GetMapping("/syncMaterial")
    public ResponseEntity syncMaterial() {
        materialTask.syncMaterial();
        return ok("同步成功！");
    }
}
