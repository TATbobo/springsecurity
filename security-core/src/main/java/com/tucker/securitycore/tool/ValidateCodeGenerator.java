package com.tucker.securitycore.tool;

import com.tucker.securitycore.bean.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
    ValidateCode createCode(ServletWebRequest request);
}
