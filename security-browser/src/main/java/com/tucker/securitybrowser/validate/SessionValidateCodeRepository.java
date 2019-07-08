package com.tucker.securitybrowser.validate;

import com.tucker.securitycore.validate.ValidateCode;
import com.tucker.securitycore.validate.ValidateCodeRepository;
import com.tucker.securitycore.validate.ValidateCodeType;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component("validateCodeRepository")
public class SessionValidateCodeRepository implements ValidateCodeRepository {

    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    private String getSessionKey(ServletWebRequest request, ValidateCodeType codeType){
        return SESSION_KEY_PREFIX+codeType.toString().toUpperCase();
    }

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType codeType) {
        sessionStrategy.setAttribute(request,getSessionKey(request,codeType),code);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType codeType) {
        return (ValidateCode)sessionStrategy.getAttribute(request,getSessionKey(request,codeType));
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType codeType) {
        sessionStrategy.removeAttribute(request,getSessionKey(request,codeType));
    }
}
