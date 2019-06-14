package com.tucker.securitycore.tool;

import com.tucker.securitycore.bean.ImageCode;

import javax.servlet.http.HttpServletRequest;

public interface ValidateCodeGenerator {
    ImageCode createImageCode(HttpServletRequest request);
}
