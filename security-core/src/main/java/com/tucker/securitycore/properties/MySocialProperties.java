package com.tucker.securitycore.properties;

import lombok.Data;

@Data
public class MySocialProperties {

    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WeiChatProperties weiChat = new WeiChatProperties();
}
