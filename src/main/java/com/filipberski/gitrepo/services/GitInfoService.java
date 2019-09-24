package com.filipberski.gitrepo.services;

import com.filipberski.gitrepo.model.GitInfo;

public interface GitInfoService {

    GitInfo getRepositoryInfo(String owner, String repository_name);


}
