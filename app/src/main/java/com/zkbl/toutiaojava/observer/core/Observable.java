package com.zkbl.toutiaojava.observer.core;

/**
 * Create by StoneBang at 2021/9/14
 */
public abstract  class  Observable<T> implements  ObservableSource<T>{
    @Override
    public void subScribeObserver(Observer<T> observer) {
        subScribelActual(observer);
    }
    //抽象类
    public abstract void subScribelActual(Observer<T> observer);

    public static <T> Observable<T> create(ObservableOnSubscribe<T>  observableOnSubscribe){
        return new OberservableCreate<T>(observableOnSubscribe);
    }
}
