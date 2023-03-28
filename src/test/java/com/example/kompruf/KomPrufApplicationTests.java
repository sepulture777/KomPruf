package com.example.kompruf;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class KomPrufApplicationTests {

    @Autowired
    private MockMvc mvc;
    @Test
    void isTheServerAvailable() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void isTheBMIcalculatedCorrectly() throws Exception {
        double weight = 85;
        double height = 1.70;
        double bmi = weight/(height*height);
        mvc.perform(MockMvcRequestBuilders.get("/bmi?weight=85&height=1.70")
                        .accept(MediaType.APPLICATION_JSON))
                        .equals(bmi);
    }

}
