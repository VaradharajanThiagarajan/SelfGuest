package com.example.SelfGuest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class SelfGuestIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getMovies() throws Exception{

        mockMvc.perform(get("/entries")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(0));
    }


    @Test
    public void addEntries() throws Exception{

        GuestBookDto guestBookObject1 = new GuestBookDto("Ram","I am 30 years old");
        mockMvc.perform(post("/entries")
                .content(objectMapper.writeValueAsString(guestBookObject1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

        mockMvc.perform(get("/entries")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].name").value("Ram"))
                .andExpect(jsonPath("[0].comments").value("I am 30 years old"))
        ;


    }


}
