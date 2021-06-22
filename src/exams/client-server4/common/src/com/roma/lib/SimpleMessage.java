package com.roma.lib;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class SimpleMessage implements Serializable {
    private String sender;
    private String text;
    private String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    public SimpleMessage(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return sender.toUpperCase() + " " + "(" + dateTime + ")" + "\n" + text + "\n";
    }
}
