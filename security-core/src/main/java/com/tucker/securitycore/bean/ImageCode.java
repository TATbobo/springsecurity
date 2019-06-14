package com.tucker.securitycore.bean;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

@Data
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image,String code,int expireTime){
        this.image=image;
        this.code=code;
        //设置验证码过期时间
        this.expireTime=LocalDateTime.now().plusSeconds(expireTime);
    }

    public ImageCode(BufferedImage image,String code,LocalDateTime expireTime){
        this.image=image;
        this.code=code;
        this.expireTime=expireTime;
    }
    public boolean isExpired(){
        //判断验证码是否过期
        return LocalDateTime.now().isAfter(expireTime);
    }

}
