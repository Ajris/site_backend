package com.ajris.site.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Test
    public void shouldReturnListOfProjectInformation() {
        List<ProjectInformation> projectInformation = List.of(ProjectInformation.builder().name("1").build());

        when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(),
                ArgumentMatchers.<ParameterizedTypeReference<List<ProjectInformation>>>any()))
                .thenReturn(new ResponseEntity<>(projectInformation, HttpStatus.OK));

        Assertions.assertEquals(projectInformation, projectService.getAllProjectInformation().join());
    }
}
