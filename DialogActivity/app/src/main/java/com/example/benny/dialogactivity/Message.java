package com.example.benny.dialogactivity;

/**
 * Created by benny on 16/11/10.
 */
public class Message {
    public static final int Send_flag = 1;
    public static final int receive_flag = 0;
    public  String content;
    public int type;

    public Message(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public  String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

}
