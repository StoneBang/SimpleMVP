package com.zkbl.toutiaojava.http.github;

import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit.RxJavaCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by StoneBang at 2021/10/11
 */
public class ServiceFactory {
    public static  OkHttpClient mOkHttpClient = new OkHttpClient();//得到个OKhttp实例
    public static <T> T createServiceFrom(final Class<T> serviceClass, String endpoint) {

        Retrofit adapter = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(getClient())//添加一个拦截器
                .build();
        return  adapter.create(serviceClass);
    }
    private static OkHttpClient getClient() {
        if(mOkHttpClient == null){
            mOkHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(getInterceptor())
                    .connectTimeout(50, TimeUnit.SECONDS)
                    .readTimeout(50, TimeUnit.SECONDS)
                    .build();

        }
        return mOkHttpClient;
    }
    private static Interceptor getInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Logger.json(message);
                System.out.println(message);
            }
        });
        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    }
}
