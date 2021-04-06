package com.example.SelfGuest;

import lombok.Value;

@Value

public class GuestBookDto {

    private String name;
    private String comments;

    public GuestBookDto(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }


}
