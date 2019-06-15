package com.tucker.securitycore.tool;

import com.tucker.securitycore.bean.ValidateCode;
import com.tucker.securitycore.properties.SecurityProperties;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component("smsCodeGenerator")
@Data
public class SmsCodeGenerator implements ValidateCodeGenerator{

    @Autowired
    private SecurityProperties securityProperties;
    @Override
    public ValidateCode createCode(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code,securityProperties.getCode().getSms().getExpireIn());
    }
}
