package com.example.SelfGuest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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


    @Test
    void fetchAllTest() {
        GuestBookEntity guestBookEntity1 = new GuestBookEntity("Suki","I am 25 years old");
        GuestBookEntity guestBookEntity2 = new GuestBookEntity("Rema","I am 65 years old");
        List<GuestBookEntity> listveri = new ArrayList<GuestBookEntity>();
        when(mockRepository.findAll()).thenReturn(listveri);
        GuestBookDto guestBookDtoObject1 = new GuestBookDto("Suki","I am 25 years old");
        GuestBookDto guestBookDtoObject2 = new GuestBookDto("Rema","I am 65 years old");
        List<GuestBookDto> listveri1 = new ArrayList<GuestBookDto>();
        listveri.add(guestBookEntity1);
        listveri.add(guestBookEntity2);

        listveri1.add(guestBookDtoObject1);
        listveri1.add(guestBookDtoObject2);

        List<GuestBookDto> guestBookDtolist1 = subject.fetchAll();

        assertThat(guestBookDtolist1).isEqualTo(listveri1);
    }

}
