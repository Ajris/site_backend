package com.ajris.site.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
class ProjectServiceImpl implements ProjectService {
    @Override
    public List<ProjectInformation> getAllProjectInformation() throws IOException {
        String content = getContent();
        List<ProjectInformation> projectInformations = convertContentToRepoList(content);
        return projectInformations;
    }

    private String getContent() throws IOException {
        URL url = new URL("https://api.github.com/users/ajris/repos?page=1&per_page=100");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }

    private static List<ProjectInformation> convertContentToRepoList(String content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, ProjectInformation.class));
    }
}
