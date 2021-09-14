package com.zkbl.toutiaojava.observer.core;

/**
 * Create by StoneBang at 2021/9/12
 *
 */
public interface ObservableOnSubscribe<T> {
    //观察什么内容,就在这里定义了
    public void subScribe(Emmiter emmiter);
}
