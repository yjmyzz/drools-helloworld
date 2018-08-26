package com.cnblogs.yjmyzz.drools.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Message {

    public enum MessageType {
        HI,
        GOODBYE,
        CHAT
    }

    private MessageType messageType;

    private String target;

}
