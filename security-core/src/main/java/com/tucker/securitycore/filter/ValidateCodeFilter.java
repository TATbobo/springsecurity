package com.tucker.securitycore.filter;


import com.tucker.securitycore.controller.ValidateCodeController;
import com.tucker.securitycore.exception.ValidateCodeException;
import com.tucker.securitycore.properties.SecurityProperties;
import com.tucker.securitycore.validate.image.ImageCode;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Data
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private AuthenticationFailureHandler authenticationFailureHandler;

    private SessionStrategy  sessionStrategy= new HttpSessionSessionStrategy();

    private Set<String> urls = new HashSet<>();

    private SecurityProperties securityProperties;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    private SessionAuthenticationStrategy sessionAuthenticationStrategy;

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getImage().getUrl(), ",");
        urls.addAll(Arrays.asList(configUrls));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        boolean action = false;

        for(String url:urls){

            if(antPathMatcher.match(url,httpServletRequest.getRequestURI())){
                action = true;
            }
            if(action /*&& StringUtils.equalsIgnoreCase(httpServletRequest.getMethod(),"post")*/){
                try {
                    validate(new ServletWebRequest(httpServletRequest));
                }catch (ValidateCodeException e){
                    authenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
                    return;
                }
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        logger.info(request.getParameter("Username"));
        logger.info(request.getParameter("Password"));
        // 从session中获取图片验证码
        ImageCode imageCodeInSession = (ImageCode) sessionStrategy.getAttribute(request, ValidateCodeController.SESSION_KEY);
        // 从请求中获取用户填写的验证码
        String imageCodeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),"imageCode");
        System.out.println("================================"+ServletRequestUtils.getStringParameter(request.getRequest(),"imageCode"));
        if (StringUtils.isBlank(imageCodeInRequest)) {
            System.out.println("验证码为空");
            throw new ValidateCodeException("验证码不能为空");
        }
        if (null == imageCodeInSession) {
            System.out.println("验证码不存在");
            throw new ValidateCodeException("验证码不存在");
        }
        if (imageCodeInSession.isExpired()) {
            System.out.println("验证码已过期");
            sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
            throw new ValidateCodeException("验证码已过期");
        }
        if (!StringUtils.equalsIgnoreCase(imageCodeInRequest, imageCodeInSession.getCode())) {
            System.out.println("验证码不匹配");
            throw new ValidateCodeException("验证码不匹配");
        }
        // 验证成功，删除session中的验证码
        logger.info("验证码成功");
        logger.info("登陆成功");
        sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
    }

}