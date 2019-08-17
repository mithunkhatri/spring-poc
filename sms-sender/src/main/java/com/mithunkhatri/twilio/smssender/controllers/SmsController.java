package com.mithunkhatri.twilio.smssender.controllers;

import com.mithunkhatri.twilio.smssender.models.SmsRequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send/sms")
@Slf4j
public class SmsController {

    @PostMapping
    public void send(@RequestBody SmsRequest request,
                     @RequestHeader("X_ACCOUNT_SID") String accountSid,
                     @RequestHeader("X_AUTH_TOKEN") String authToken) {
        Twilio.init(accountSid, authToken);

        Message message = Message
                .creator(new PhoneNumber(request.getTo()),
                        new PhoneNumber(request.getFrom()),
                        request.getText())
                .create();

        log.info("Sms sent. sid : " + message.getSid());
    }
}
