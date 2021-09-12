package com.zkbl.toutiaojava.presenter.View;

/**
 * Create by StoneBang at 2021/9/12
 */
public interface BaseView<T> {
    public void setData(T data);
    public void setError();
}
