package com.zkbl.toutiaojava.observer.core;

/**
 * Create by StoneBang at 2021/9/14
 */
public interface ObservableSource <T>{

    public void subScribeObserver(Observer<T> observer);

}
