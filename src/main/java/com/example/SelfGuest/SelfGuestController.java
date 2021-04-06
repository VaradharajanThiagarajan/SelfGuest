package com.example.SelfGuest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SelfGuestController {

    @GetMapping("/entries")
    public String getEntries(){
        return "[]";
    }

    @PostMapping("/entries")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovie(){

    }

}
