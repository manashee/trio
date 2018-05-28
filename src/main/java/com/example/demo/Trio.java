package com.example.demo;

public class Trio {


    private final Long id;
    private final String message;

    Trio(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

}
