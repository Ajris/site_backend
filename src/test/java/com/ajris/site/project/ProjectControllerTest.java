package com.ajris.site.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProjectService blogService;

    @Test
    public void shouldGetProjectsInformation() throws Exception {
        given(blogService.getAllProjectInformation())
                .willReturn(CompletableFuture.completedFuture(
                        List.of(ProjectInformation.builder().name("nazwa").build())));

        mvc.perform(get("/api/project"))
                .andExpect(status().is(HttpStatus.ACCEPTED.value()))
                .andExpect(header().string(CONTENT_TYPE, APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$[0].name").value("nazwa"))
                .andReturn();
    }
}
