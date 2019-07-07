package com.ajris.site.technology;

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
@WebMvcTest(TechnologyController.class)
public class TechnologyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TechnologyService aboutService;

    @Test
    public void whenAskingForTechnologyInformationReturnList() throws Exception {
        TechnologyInformation aboutInformation = new TechnologyInformation("1", "1");
        List<TechnologyInformation> allInformation = Collections.singletonList(aboutInformation);
        given(aboutService.getAllTechnologyInformation()).willReturn(allInformation);

        mockMvc.perform(get("/technology")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(aboutInformation.getName())));

        verify(aboutService, times(1)).getAllTechnologyInformation();
    }
}
