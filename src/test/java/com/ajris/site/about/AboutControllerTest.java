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
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AboutController.class)
public class AboutControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AboutService aboutService;

    @Test
    public void whenAskingForAboutInformationReturnList() throws Exception {
//        AboutInformation aboutInformation = AboutInformation.builder().id("1").largeInformation("1").build();
//        List<AboutInformation> allInformation = Collections.singletonList(aboutInformation);
//        given(aboutService.getAllAboutInformations()).willReturn(allInformation);
//
//        mockMvc.perform(get("/about")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].largeInformation", is(aboutInformation.getLargeInformation())));
//
//        verify(aboutService, times(1)).getAllAboutInformations();
    }
}
