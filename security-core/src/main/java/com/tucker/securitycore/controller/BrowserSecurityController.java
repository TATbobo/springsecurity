package com.tucker.securitycore.controller;

import com.tucker.securitycore.bean.SimpleResponse;
import com.tucker.securitycore.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class BrowserSecurityController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @RequestMapping("/authentication/require")
 /*   @ResponseStatus(code = HttpStatus.UNAUTHORIZED)*/
    public SimpleResponse requireAuthentication(HttpServletRequest request , HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        String requestAccept = request.getHeader("accept");
        logger.info(requestAccept);
        String contentType = "text/html";

        if(savedRequest != null){
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的Url是===="+targetUrl);
            if(requestAccept.contains(contentType)){
                redirectStrategy.sendRedirect(request,response,securityProperties.getBrowser().getLoginPage());
            }
        }
        return new SimpleResponse("请引导用户到登录页");
    }
}
