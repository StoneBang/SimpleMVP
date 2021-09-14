package com.zkbl.toutiaojava.observer.core;

/**
 * Create by StoneBang at 2021/9/14
 */
public class Emmiter<T>{
    public Observer<T> observer;
    public boolean isDone;
    public void onNext(T t){
        observer.onNext(t);
    };

    public void onComplete(){
        isDone = true;
    };

    public Emmiter(Observer<T> observer) {
        this.observer = observer;
    }

    public void onError(Throwable throwable){
        this.observer.onError(throwable);
    };

    public void onSubscribe(){};

}
