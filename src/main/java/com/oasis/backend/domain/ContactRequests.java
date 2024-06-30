package com.oasis.backend.domain;

import java.time.LocalDateTime;

public class ContactRequests {

    private int requestsId;
    private String name;
    private String email;
    private String message;
    private LocalDateTime date;
    private String state;

    public int getRequestsId() {
        return requestsId;
    }

    public void setRequestsId(int requestsId) {
        this.requestsId = requestsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
