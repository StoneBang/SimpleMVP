package com.zkbl.toutiaojava.http;

import com.orhanobut.logger.Logger;
import com.zkbl.toutiaojava.base.Constant;
import com.zkbl.toutiaojava.bean.BaseModel;
import com.zkbl.toutiaojava.bean.highValue.Goods;
import com.zkbl.toutiaojava.bean.highValue.ManuFacture;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by StoneBang at 2021/9/13
 */
public class HttpUtil {

    private static OkHttpClient mOkHttpClient;

    public static ApiService createApi(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
        return retrofit.create(ApiService.class);
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
            }
        });
        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public static void getGoodsList(ResponseListener<BaseModel<Goods>> responseListener){
        Call<BaseModel<Goods>> goods = createApi().getGoodsList();
        goods.enqueue(new Callback<BaseModel<Goods>>() {
            @Override
            public void onResponse(Call<BaseModel<Goods>> call, Response<BaseModel<Goods>> response) {
                Logger.d(response.body());
                responseListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<BaseModel<Goods>> call, Throwable t) {
                Logger.d(t.getMessage());
                responseListener.onFail(t.getMessage());
            }
        });
    }
    public static void getManufacturerList(ResponseListener<BaseModel<ManuFacture>> responseListener){
        Call<BaseModel<ManuFacture>> goods = createApi().getManufacturerList();
        goods.enqueue(new Callback<BaseModel<ManuFacture>>() {
            @Override
            public void onResponse(Call<BaseModel<ManuFacture>> call, Response<BaseModel<ManuFacture>> response) {
                Logger.d(response.body());
                responseListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<BaseModel<ManuFacture>> call, Throwable t) {
                Logger.d(t.getMessage());
                responseListener.onFail(t.getMessage());
            }
        });
    }
}
