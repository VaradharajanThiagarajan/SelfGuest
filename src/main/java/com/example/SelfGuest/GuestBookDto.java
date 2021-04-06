package com.example.SelfGuest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor

public class GuestBookDto {

    private String name;
    private String comments;

    public GuestBookDto(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }


}
