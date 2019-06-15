package com.tucker.securitycore.sms;

public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机发送短信验证码===========");
        System.out.println("手机号:"+mobile);
        System.out.println("验证码:"+code);
    }
}
