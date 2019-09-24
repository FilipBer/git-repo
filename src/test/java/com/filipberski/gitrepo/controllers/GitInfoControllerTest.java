package com.filipberski.gitrepo.controllers;

import com.filipberski.gitrepo.services.GitInfoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GitInfoControllerTest {



    GitInfoController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.controller = new GitInfoController(new GitInfoServiceImpl());
    }

    @Test
    public void getInfoNotFound() throws Exception {
        String owner = "aaaa";
        String repoName = "octokit.rb";
        String request = "http://localhost:8080/repositories/" + owner + "/" + repoName;

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


        mockMvc.perform(get(request))
                .andExpect(status().isNotFound());
    }
}

