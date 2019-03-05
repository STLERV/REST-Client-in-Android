package com.example.tutorial;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;

public class ContributorsService {

    GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
    Call<List<Contributor>> call = gitHubService.repoContributors("square","retrofit");
    List<Contributor> result = call.execute().body();

public ContributorsService() throws IOException{}

}
