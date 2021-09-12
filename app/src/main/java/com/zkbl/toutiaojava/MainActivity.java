package com.zkbl.toutiaojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.zkbl.toutiaojava.base.BaseActivity;
import com.zkbl.toutiaojava.presenter.BasePresenter;
import com.zkbl.toutiaojava.presenter.MainPresenter;
import com.zkbl.toutiaojava.presenter.View.BaseView;
import com.zkbl.toutiaojava.presenter.View.MainView;

public class MainActivity extends BaseActivity<MainView> implements MainView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void init() {
        ((MainPresenter)getPresenter()).loadData("去请求数据");
    }

    @Override
    protected BasePresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void setData(Object data) {
        Log.e("TAG", "setData: "+data );
    }

    @Override
    public void setError() {

    }
}