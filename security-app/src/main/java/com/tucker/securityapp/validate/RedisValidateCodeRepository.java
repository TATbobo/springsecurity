package com.tucker.securityapp.validate;

import com.tucker.securitycore.exception.ValidateCodeException;
import com.tucker.securitycore.validate.ValidateCode;
import com.tucker.securitycore.validate.ValidateCodeRepository;
import com.tucker.securitycore.validate.ValidateCodeType;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;

@Component("validateCodeRepository")
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType codeType) {
        redisTemplate.opsForValue().set(buildKey(request,codeType),code,30, TimeUnit.MINUTES);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType codeType) {
        Object value = redisTemplate.opsForValue().get(buildKey(request,codeType));
        if ((value == null)){
            return null;
        }
        return (ValidateCode) value;
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType codeType) {
        redisTemplate.delete(buildKey(request,codeType));
    }

    private String buildKey(ServletWebRequest request, ValidateCodeType codeType){
        String deviceId = request.getHeader("deviceId");
        if(StringUtils.isBlank(deviceId)){
            throw new ValidateCodeException("请在请求头中携带deviceId参数");
        }
        return "code:" +codeType.toString().toLowerCase()+":"+deviceId;
    }
}
