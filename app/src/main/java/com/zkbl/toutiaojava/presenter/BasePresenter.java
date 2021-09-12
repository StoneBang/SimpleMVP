package com.zkbl.toutiaojava.presenter;

/**
 * Create by StoneBang at 2021/9/12
 */
public class BasePresenter<V> {

    private V mBaseView;

    public void bindView(V baseView){
        this.mBaseView = baseView;
    }

    public void unBindView(){
        this.mBaseView = null;
    }

    public V getBaseView(){
        return  mBaseView;
    }
}
