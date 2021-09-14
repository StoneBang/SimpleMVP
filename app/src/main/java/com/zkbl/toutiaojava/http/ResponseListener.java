package com.zkbl.toutiaojava.http;

/**
 * Create by StoneBang at 2021/9/14
 */
public interface ResponseListener<T> {
    public void onSuccess(T data);
    public void onFail(String msg);
}
