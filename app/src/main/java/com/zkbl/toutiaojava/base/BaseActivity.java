package com.zkbl.toutiaojava.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zkbl.toutiaojava.presenter.BasePresenter;

public abstract  class BaseActivity<V> extends AppCompatActivity {

    protected BasePresenter<V> mBasePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if(mBasePresenter == null){
            mBasePresenter = createPresenter();
            mBasePresenter.bindView((V)this);
        }
        init();
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void init();

    protected abstract BasePresenter<V> createPresenter();

    public BasePresenter getPresenter() {
        return mBasePresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBasePresenter.unBindView();
    }
}