package com.tucker.securitycore.social.WeiChat.connet;

import com.tucker.securitycore.social.WeiChat.api.WeiChat;
import com.tucker.securitycore.social.WeiChat.api.WeiChatUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

public class WeiChatAdapter implements ApiAdapter<WeiChat> {

    private String openId;

    public WeiChatAdapter(){}

    public WeiChatAdapter(String openId){
        this.openId = openId;
    }

    @Override
    public boolean test(WeiChat weiChat) {
        return false;
    }

    @Override
    public void setConnectionValues(WeiChat api, ConnectionValues values) {
        WeiChatUserInfo profile = api.getUserInfo(openId);
        values.setProviderUserId(profile.getOpenid());
        values.setDisplayName(profile.getNickname());
        values.setImageUrl(profile.getHeadimgurl());
    }

    @Override
    public UserProfile fetchUserProfile(WeiChat weiChat) {
        return null;
    }

    @Override
    public void updateStatus(WeiChat weiChat, String s) {

    }
}
