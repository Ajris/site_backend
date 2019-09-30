package com.ajris.site.blog;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BlogController.class)
@AutoConfigureMockMvc

public class BlogControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BlogService blogService;

    @Disabled
    @Test
    public void shouldGetBlogInformation() throws Exception {
        given(blogService.getAllBlogInformation())
                .willReturn(CompletableFuture.completedFuture(List.of(new BlogInformation("1", "1"))));

        mvc.perform(get("/api/blog"))
                .andExpect(status().is(HttpStatus.ACCEPTED.value()))
                .andExpect(header().string(CONTENT_TYPE, APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title").value("1"))
                .andExpect(jsonPath("$[0].shortText").value("1"))
                .andReturn();
    }


}
