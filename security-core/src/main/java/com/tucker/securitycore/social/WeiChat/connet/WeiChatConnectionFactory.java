package com.tucker.securitycore.social.WeiChat.connet;

import com.tucker.securitycore.social.WeiChat.api.WeiChat;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.support.OAuth2Connection;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

public class WeiChatConnectionFactory extends OAuth2ConnectionFactory<WeiChat> {

    public WeiChatConnectionFactory(String providerId, String appId,String appSecret) {
        super(providerId, new WeiChatServieProvider(appId,appSecret), new WeiChatAdapter());
    }

    @Override
    protected String extractProviderUserId(AccessGrant accessGrant) {
        if(accessGrant instanceof WeiChatAccessGrant){
            return (((WeiChatAccessGrant) accessGrant).getOpenId());
        }
        return null;
    }
    /* (non-Javadoc)
     * @see org.springframework.social.connect.support.OAuth2ConnectionFactory#createConnection(org.springframework.social.oauth2.AccessGrant)
     */
    public Connection<WeiChat> createConnection(AccessGrant accessGrant) {
        return new OAuth2Connection<WeiChat>(getProviderId(), extractProviderUserId(accessGrant), accessGrant.getAccessToken(),
                accessGrant.getRefreshToken(), accessGrant.getExpireTime(), getOAuth2ServiceProvider(), getApiAdapter(extractProviderUserId(accessGrant)));
    }

    /* (non-Javadoc)
     * @see org.springframework.social.connect.support.OAuth2ConnectionFactory#createConnection(org.springframework.social.connect.ConnectionData)
     */
    public Connection<WeiChat> createConnection(ConnectionData data) {
        return new OAuth2Connection<WeiChat>(data, getOAuth2ServiceProvider(), getApiAdapter(data.getProviderUserId()));
    }

    private ApiAdapter<WeiChat> getApiAdapter(String providerUserId) {
        return new WeiChatAdapter(providerUserId);
    }

    private OAuth2ServiceProvider<WeiChat> getOAuth2ServiceProvider() {
        return (OAuth2ServiceProvider<WeiChat>) getServiceProvider();
    }
}
