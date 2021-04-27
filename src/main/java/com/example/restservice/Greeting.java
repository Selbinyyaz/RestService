package com.example.restservice;

public class Greeting {
	private final String message;
    private final String timestamp;

    public Greeting(String message, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }
    public String getTimeStamp() {
        return timestamp;
    }

}
