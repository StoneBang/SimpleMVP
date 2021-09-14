package com.zkbl.toutiaojava.observer.core;

import com.zkbl.toutiaojava.R;

/**
 * Create by StoneBang at 2021/9/12
 */
public class OberservableCreate<T> extends Observable<T> {
    private   ObservableOnSubscribe<T> mObservableOnSubscribe;
    public OberservableCreate(ObservableOnSubscribe<T> mObservableOnSubscribe) {
        this.mObservableOnSubscribe = mObservableOnSubscribe;
    }

    @Override
    public void subScribelActual(Observer<T> observer) {
        Emmiter<T> emmiter = new Emmiter<T>(observer);
        mObservableOnSubscribe.subScribe(emmiter);
        observer.onSubscribe();
    }
}
