package com.ajris.site.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@TestPropertySource("classpath:application-integrationtest.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BlogIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldGetBlogInformationFromDatabase() throws Exception {
        mvc.perform(get("/api/blog"))
                .andExpect(status().is(HttpStatus.ACCEPTED.value()))
                .andExpect(header().string(CONTENT_TYPE, APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].title").value("b"))
                .andExpect(jsonPath("$[0].shortText").value("a"))
                .andReturn();
    }
}
