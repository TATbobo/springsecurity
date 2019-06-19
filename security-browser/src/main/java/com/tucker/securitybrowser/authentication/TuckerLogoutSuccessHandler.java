package com.tucker.securitybrowser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tucker.securitybrowser.support.SimpleResponse;
import com.tucker.securitycore.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TuckerLogoutSuccessHandler implements LogoutSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public TuckerLogoutSuccessHandler(String logoutUrl){
        this.logoutUrl = logoutUrl;
    }

    @Autowired
    private String logoutUrl;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("退出成功");

        if(StringUtils.isBlank(logoutUrl)){
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        }else{
            httpServletResponse.sendRedirect(logoutUrl);
        }

    }
}
