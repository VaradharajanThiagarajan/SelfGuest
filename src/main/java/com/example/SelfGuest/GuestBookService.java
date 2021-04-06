package com.example.SelfGuest;

import org.springframework.stereotype.Service;

@Service

public class GuestBookService {

    private final GuestBookRepository guestBookRepos;

    GuestBookService(GuestBookRepository mockRepos)
    {
        this.guestBookRepos = mockRepos;
    }

    public void create(GuestBookDto guestBookdtoobj){
        guestBookRepos.save(
                new GuestBookEntity(guestBookdtoobj.getName(),guestBookdtoobj.getComments())
        );

    }

}
