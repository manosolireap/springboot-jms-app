package com.mano.jmsapp.jmsapp;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @JmsListener(destination = "msgQueue",
            containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String msg) {
        System.out.println("Message Received\n\n");
        System.out.println("Message received from Queue: "+msg);
    }

}
