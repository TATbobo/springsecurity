package com.tucker.securitycore.validate;

import org.springframework.web.context.request.ServletWebRequest;


public interface ValidateCodeRepository {

    void save(ServletWebRequest request,ValidateCode code,ValidateCodeType codeType);

    ValidateCode get(ServletWebRequest request, ValidateCodeType codeType);

    void remove(ServletWebRequest request,ValidateCodeType codeType);
}
