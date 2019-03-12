package com.example.tutorial;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

public class ContributorsService {

    GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
    Call<List<Tracks>> call = gitHubService.mistracks();
    List<Tracks> result = call.execute().body();

public ContributorsService() throws IOException{}

}
