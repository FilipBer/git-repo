package com.filipberski.gitrepo.services;

import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;

public class GitInfoServiceImplTest {

    private GitInfoService gitInfoService = new GitInfoServiceImpl();
    private String owner = "octokit";
    private String repositoryName = "octokit.rb";


    @Test(expected = HttpClientErrorException.class)
    public void getRepositoryInfoBadOwner() {
        owner = "aaaaa";
        gitInfoService.getRepositoryInfo(owner, repositoryName);

    }

    @Test(expected = HttpClientErrorException.class)
    public void getRepositoryInfoBadRepoName() {
        repositoryName = "aaaaa";
        gitInfoService.getRepositoryInfo(owner, repositoryName);

    }
}
