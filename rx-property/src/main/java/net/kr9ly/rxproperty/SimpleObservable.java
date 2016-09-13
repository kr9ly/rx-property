package net.kr9ly.rxproperty;

import android.databinding.BaseObservable;

import rx.Observer;

public class SimpleObservable<T> extends BaseObservable implements Observer<T> {

    private T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
        notifyChange();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {
        set(t);
    }
}
