package com.sinosoft.doubledatasource.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class WatermarkImgUtils {

//    public static void main(String[] args) {
//        System.out.println("开始水印：");
//        new WatermarkImgUtils().addWatermark("f:/123.jpg", "f:/456.jpg", "你好，世界！", "jpg");
//        System.out.println("水印完成。");
//    }

    private static final Logger logger = LoggerFactory.getLogger(WatermarkImgUtils.class);


    /**
     * @description
     * @param waterMarkContent 水印内容
     * @return void
     */
    public byte[] addWatermark(byte[] byt , String waterMarkContent){
        logger.info("水印内容是："+waterMarkContent);
        Font font = new Font("宋体", Font.BOLD, 50);//水印字体，大小
        Color markContentColor = Color.GRAY;//水印颜色
        Integer degree = 45;//设置水印文字的旋转角度
        float alpha = 0.8f;//设置水印透明度
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            InputStream input = new ByteArrayInputStream(byt);
            Image srcImg = ImageIO.read(input);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();//得到画笔
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //设置水印颜色
            g.setFont(font);              //设置字体
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));//设置水印文字透明度
            if (null != degree) {
                g.rotate(Math.toRadians(degree));//设置水印旋转
            }
            JLabel label = new JLabel(waterMarkContent);
            FontMetrics metrics = label.getFontMetrics(font);
            int width = metrics.stringWidth(label.getText());//文字水印的宽
            logger.info("文字水印的宽是："+width);
            int rowsNumber = srcImgHeight/width;// 图片的高  除以  文字水印的宽    ——> 打印的行数(以文字水印的宽为间隔)
            int columnsNumber = srcImgWidth/width;//图片的宽 除以 文字水印的宽   ——> 每行打印的列数(以文字水印的宽为间隔)
            //防止图片太小而文字水印太长，所以至少打印一次
            if(rowsNumber < 1){
                rowsNumber = 1;
            }
            if(columnsNumber < 1){
                columnsNumber = 1;
            }
            for(int j=0;j<rowsNumber;j++){
                for(int i=0;i<columnsNumber;i++){
                    g.drawString(waterMarkContent, i*width + j*width, -i*width + j*width);//画出水印,并设置水印位置
                }
            }
            g.dispose();// 释放资源
            // 输出图片
            ImageIO.write(bufImg, "jpg", out);

            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        } finally{
            try {
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
        return new byte[0];
    }
}
