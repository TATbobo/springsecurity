package com.tucker.securitycore.social.qq.connet;

import com.tucker.securitycore.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId,String appSecret) {
        super(providerId, new QQSericeProvider(appId,appSecret), new QQAdapter());
    }
}
