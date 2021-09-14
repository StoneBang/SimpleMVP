package com.zkbl.toutiaojava.http;

import com.zkbl.toutiaojava.bean.BaseModel;
import com.zkbl.toutiaojava.bean.Goods;
import com.zkbl.toutiaojava.bean.ManuFacture;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Create by StoneBang at 2021/9/13
 */
interface  ApiService {
    @GET("/wms_gk/api/base/getGoodsList")
    public Call<BaseModel<Goods>> getGoodsList();
    @GET("/wms_gk/api/base/getManufacturerList")
    public Call<BaseModel<ManuFacture>> getManufacturerList();
}
