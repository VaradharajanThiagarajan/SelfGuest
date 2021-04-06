package com.example.SelfGuest;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<GuestBookDto> fetchAll() {
        return guestBookRepos.findAll()
                .stream()
                .map(guestBookEntity -> {
                    return new GuestBookDto(guestBookEntity.getName(),guestBookEntity.getComments());
                })
                .collect(Collectors.toList());
    }

}
