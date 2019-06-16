package com.tucker.securitycore.validate;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ValidateCode {

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code,int expireIn){
        this.code = code;
        this.expireTime=LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code,LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpired(){
        //判断验证码是否过期
        return LocalDateTime.now().isAfter(expireTime);
    }

}
