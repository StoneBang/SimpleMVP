package com.zkbl.toutiaojava.bean.github;

/**
 * Create by StoneBang at 2021/10/11
 */
public  class GithubRepo {
    public String name; // 库的名字
    public String description; // 描述
    public String language; // 语言

    @Override
    public String toString() {
        return "GithubRepo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
