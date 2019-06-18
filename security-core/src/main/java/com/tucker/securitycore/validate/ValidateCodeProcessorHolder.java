package com.tucker.securitycore.validate;

import com.tucker.securitycore.exception.ValidateCodeException;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component("validateCodeProcessorHolder")
public class ValidateCodeProcessorHolder {

    private int a = 1;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Map<String,ValidateCodeProcessor> validateCodeProcessors;

    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + "CodeProcessor";
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            logger.info("验证码处理器" + name + "不存在");
            throw new ValidateCodeException("验证码处理器" + name + "不存在");
        }
        return processor;
    }

}