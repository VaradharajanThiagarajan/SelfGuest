package com.example.SelfGuest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SelfGuestServiceTest {

    @Mock
    GuestBookRepository mockRepository;

    @InjectMocks
    GuestBookService subject;

    @Test
    void create(){
        GuestBookDto guestBookDtoobj1 = new GuestBookDto("Shyam","I am 35 years old");
        subject.create(guestBookDtoobj1);
        verify(mockRepository).save(
                new GuestBookEntity("Shyam","I am 35 years old")
        );
    }
}
