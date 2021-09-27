package com.zkbl.toutiaojava.http;

/**
 * Create by StoneBang at 2021/9/24
 */
public interface  DownloadListener {
    void onStart();//下载开始

    void onProgress(int progress);//下载进度

    void onFinish(String path);//下载完成

    void onFail(String errorInfo);//下载失败
}
