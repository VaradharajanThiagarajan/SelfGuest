package com.example.SelfGuest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

@RestController

public class SelfGuestController {

    //List<GuestBookDto> guestEntriesList = new ArrayList<GuestBookDto>();
    GuestBookService guestBookServiceobj;

    public SelfGuestController(GuestBookService guestBookServiceobj) {
        this.guestBookServiceobj = guestBookServiceobj;
    }

    @GetMapping("/entries")
    public  List<GuestBookDto> getEntries(){
        return this.guestBookServiceobj.fetchAll();
    }

    @PostMapping("/entries")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovie(@RequestBody GuestBookDto guestBookDtoobject){
        //guestEntriesList.add(guestBookDtoobject);
        this.guestBookServiceobj.create(guestBookDtoobject);

    }

}
