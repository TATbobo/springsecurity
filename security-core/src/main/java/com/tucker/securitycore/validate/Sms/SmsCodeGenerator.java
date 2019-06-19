package com.tucker.securitycore.validate.Sms;

import com.tucker.securitycore.properties.SecurityProperties;
import com.tucker.securitycore.validate.ValidateCode;
import com.tucker.securitycore.validate.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

        Logger logger = LoggerFactory.getLogger(getClass());

        @Autowired
        private SecurityProperties securityProperties;

        @Override
        public ValidateCode generator(ServletWebRequest request) {
            String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
            logger.info("生成短信验证码====="+code);
            return new ValidateCode(code,securityProperties.getCode().getSms().getExpireIn());
        }
    }
