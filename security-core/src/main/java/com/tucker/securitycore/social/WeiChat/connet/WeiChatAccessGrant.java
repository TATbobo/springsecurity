package com.tucker.securitycore.social.WeiChat.connet;

import lombok.Data;
import org.springframework.social.oauth2.AccessGrant;

@Data
public class WeiChatAccessGrant extends AccessGrant {

    private String openId;

    public WeiChatAccessGrant() {
        super("");
    }

    public WeiChatAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }
}
