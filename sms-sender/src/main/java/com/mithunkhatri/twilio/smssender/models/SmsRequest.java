package com.mithunkhatri.twilio.smssender.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SmsRequest {

    private String from;
    private String to;
    private String text;
}