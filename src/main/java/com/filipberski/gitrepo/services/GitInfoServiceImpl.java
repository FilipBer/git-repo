package com.filipberski.gitrepo.services;

import com.filipberski.gitrepo.model.GitInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitInfoServiceImpl implements GitInfoService {
    @Override
    public GitInfo getRepositoryInfo(String owner, String repositoryName) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.github.com/repos/" + owner + "/" + repositoryName, GitInfo.class);
    }
}
