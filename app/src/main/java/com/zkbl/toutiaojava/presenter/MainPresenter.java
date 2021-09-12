package com.zkbl.toutiaojava.presenter;

import com.zkbl.toutiaojava.presenter.View.BaseView;
import com.zkbl.toutiaojava.presenter.View.MainView;

/**
 * Create by StoneBang at 2021/9/12
 */
public class MainPresenter extends BasePresenter<MainView> {

    public void loadData(String str){
        getBaseView().setData(str);
    }
}

