package com.ajris.site.about;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(AboutController.class)
public class AboutControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AboutService aboutService;

    @Test
    public void whenAskingForAboutInformationReturnList() throws Exception {
        AboutInformation aboutInformation = new AboutInformation("1", "1");
        List<AboutInformation> allInformation = Collections.singletonList(aboutInformation);
        given(aboutService.getAllAboutInformations()).willReturn(allInformation);

        mockMvc.perform(get("/about")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(aboutInformation.getName())));

        verify(aboutService, times(1)).getAllAboutInformations();
    }
}
