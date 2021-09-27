package com.zkbl.toutiaojava.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Create by StoneBang at 2021/9/24
 */
public interface DownLoadService {
    @Streaming
    @GET("work/config.xml?versionId=CAEQNBiBgIC865De4BciIGI3MjQ1MzI1NjFmMjRiYWM5Y2QwZjQyY2Y2NmQ1MWFm")
    Call<ResponseBody> downLoad();

}
