package com.zkbl.toutiaojava.bean.github;

/**
 * Create by StoneBang at 2021/10/11
 */
// 用户类, 名称必须与Json解析相同
public  class GithubUser {
    public String login;
    public String avatar_url;
    public String name;
    public String repos_url;

    @Override
    public String toString() {
        return "GithubUser{" +
                "login='" + login + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", name='" + name + '\'' +
                ", repos_url='" + repos_url + '\'' +
                '}';
    }
}
