package com.example.appclass_1.javaegs;

public class messageImpl implements IMessage{
    @Override
    public void sendMessage() {
        System.out.println("sending message from impl");
    }

}
