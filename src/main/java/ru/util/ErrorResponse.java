package ru.util;

public class ErrorResponse {
    private String messge;
    private long timestamp;

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ErrorResponse(String messge, long timestamp) {
        this.messge = messge;
        this.timestamp = timestamp;


    }
}
