package com.tucker.securitycore.social.WeiChat.config;

import com.tucker.securitycore.properties.QQProperties;
import com.tucker.securitycore.properties.SecurityProperties;
import com.tucker.securitycore.properties.WeiChatProperties;
import com.tucker.securitycore.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;

@Configuration
@ConditionalOnProperty(prefix = "tucker.security.weiChat",name = "app-id")
public class WeiChatAutoConfiguration extends SocialConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    public ConnectionFactory<?> createConnectionFactory() {
        WeiChatProperties weiChatConfig = securityProperties.getSocial().getWeiChat();
        return new QQConnectionFactory(weiChatConfig.getProviderId(),weiChatConfig.getAppId(),weiChatConfig.getAppSecret());
    }

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer configurer, Environment environment) {
        configurer.addConnectionFactory(createConnectionFactory());
    }
}
