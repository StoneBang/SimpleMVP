package com.zkbl.toutiaojava.http.github;


import com.zkbl.toutiaojava.bean.github.GithubRepo;
import com.zkbl.toutiaojava.bean.github.GithubUser;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Create by StoneBang at 2021/10/11
 */
public interface GithubService {
    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}") // 获取个人信息
    Observable<GithubUser> getUserData(@Path("user") String user);

    @GET("/users/{user}/repos") // 获取库, 获取的是数组
    Observable<GithubRepo[]> getRepoData(@Path("user") String user);
}
