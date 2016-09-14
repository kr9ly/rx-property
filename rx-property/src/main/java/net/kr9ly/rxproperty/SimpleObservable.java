package net.kr9ly.rxproperty;

import android.databinding.ObservableField;

import rx.Observer;

public class SimpleObservable<T> extends ObservableField<T> implements Observer<T> {

    private T value;

    public void set(T value) {
        super.set(value);
        if (this.value == value) {
            notifyChange();
        }
        this.value = value;
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
