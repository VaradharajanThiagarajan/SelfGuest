package com.example.SelfGuest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SelfGuestController {

    @GetMapping("/entries")
    public String getEntries(){
        return "[]";
    }
}
