package com.sinosoft.doubledatasource.enums;

import java.io.File;

public class FilePathEnum {

    //前缀
    public static String commonPath = "";

    /**
     * 初始化项目路径
     */
    static {
        String projectPath = System.getProperty("user.dir");
        commonPath = projectPath + File.separator + "upload-dir" + File.separator;
    }


    public static final String 上传路径 = commonPath + "upload" + File.separator;

    public static final String 下载路径 = commonPath + "download" + File.separator;

    public static final String 模板路径 = commonPath + "template" + File.separator;

    public static final String WORD = "0";

    public static final String PDF = "1";



}
