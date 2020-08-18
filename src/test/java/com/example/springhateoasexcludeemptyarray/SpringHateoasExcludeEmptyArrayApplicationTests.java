package com.example.springhateoasexcludeemptyarray;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringHateoasExcludeEmptyArrayApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void withSelfLink() throws Exception {

        mockMvc.perform(
                get("/user/alice?isWithSelfLink=true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("alice"))
                .andExpect(jsonPath("$.links").exists())
                .andDo(print());
    }

    @Test
    void withoutSelfLink() throws Exception {

        mockMvc.perform(
                get("/user/alice?isWithSelfLink=false")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("alice"))
                .andExpect(jsonPath("$.links").doesNotExist())
                .andDo(print());
    }

}
