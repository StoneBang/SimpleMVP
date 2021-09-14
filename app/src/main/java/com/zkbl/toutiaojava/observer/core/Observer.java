package com.zkbl.toutiaojava.observer.core;

/**
 * Create by StoneBang at 2021/9/12
 */
public interface Observer<T> {
    public void onNext(T t);

    public void onComplete();

    public void onError(Throwable throwable);

    public void onSubscribe();
}
