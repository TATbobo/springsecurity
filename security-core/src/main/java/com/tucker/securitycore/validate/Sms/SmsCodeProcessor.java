package com.tucker.securitycore.validate.Sms;

import com.tucker.securitycore.properties.SecurityConstants;
import com.tucker.securitycore.validate.ValidateCode;
import com.tucker.securitycore.validate.imp.AbstractValidateCodeProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

@Component("smsCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(),paramName);
        smsCodeSender.send(mobile,validateCode.getCode());
    }
}
