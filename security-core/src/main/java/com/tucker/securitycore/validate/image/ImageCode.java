package com.tucker.securitycore.validate.image;

import com.tucker.securitycore.validate.ValidateCode;
import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

@Data
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image,String code,int expireIn){
        super(code,expireIn);
        this.image=image;
    }

    public ImageCode(BufferedImage image,String code,LocalDateTime expireTime){
        super(code,expireTime);
        this.image=image;
    }
}
