package com.filipberski.gitrepo.controllers;

import com.filipberski.gitrepo.services.GitInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class GitInfoController {

    private GitInfoService gitInfoService;

    public GitInfoController(GitInfoService gitInfoService) {
        this.gitInfoService = gitInfoService;
    }

    @GetMapping( value = "/repositories/{owner}/{repo-name}", produces = "application/json")
    public ResponseEntity getInfo(@PathVariable(value = "owner") String owner, @PathVariable(value = "repo-name") String repositoryName) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(gitInfoService.getRepositoryInfo(owner, repositoryName));
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nie znaleziono strony", e);
        }
    }
}
