package com.tucker.securitycore.social.WeiChat.connet;

import com.sun.org.apache.regexp.internal.RE;
import com.tucker.securitycore.social.WeiChat.api.WeiChat;
import com.tucker.securitycore.social.WeiChat.api.WeiChatImp;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;

public class WeiChatServieProvider extends AbstractOAuth2ServiceProvider<WeiChat> {

    /**
     * 微信获取授权码的url
     */
    private static final String URL_AUTHORIZE = "https://open.weixin.qq.com/connect/qrconnect";
    /**
     * 微信获取accessToken的url
     */
    private static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";

    public WeiChatServieProvider(String appId, String appSecret) {
        super(new WeiChatAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
    }

    @Override
    public WeiChat getApi(String accessToken) {
        return new WeiChatImp(accessToken);
    }
}
