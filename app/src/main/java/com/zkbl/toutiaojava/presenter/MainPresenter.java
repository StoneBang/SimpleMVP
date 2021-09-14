package com.zkbl.toutiaojava.presenter;

import android.util.Log;

import com.zkbl.toutiaojava.bean.BaseModel;
import com.zkbl.toutiaojava.bean.ManuFacture;
import com.zkbl.toutiaojava.http.HttpUtil;
import com.zkbl.toutiaojava.http.ResponseListener;
import com.zkbl.toutiaojava.presenter.View.BaseView;
import com.zkbl.toutiaojava.presenter.View.MainView;

/**
 * Create by StoneBang at 2021/9/12
 */
public class MainPresenter extends BasePresenter<MainView> {

    public void loadData(){
        HttpUtil.getManufacturerList(new ResponseListener<BaseModel<ManuFacture>>() {
            @Override
            public void onSuccess(BaseModel<ManuFacture> data) {
                Log.e("TAG", "onSuccess: " );
                getBaseView().setData(data);
            }

            @Override
            public void onFail(String msg) {
                Log.e("TAG", "fail: " );
            }
        });
    }
}

