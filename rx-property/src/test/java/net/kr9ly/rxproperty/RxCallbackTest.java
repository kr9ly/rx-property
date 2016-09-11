package net.kr9ly.rxproperty;

import com.google.common.collect.Lists;

import net.kr9ly.rxproperty.callback.RxOnClickCallback;

import org.junit.Test;

import rx.observers.TestSubscriber;

public class RxCallbackTest {

    @Test
    public void testUpdate() {
        TestSubscriber<Void> subscriber = new TestSubscriber<Void>();

        RxOnClickCallback callback = RxCallbacks.onClick();
        callback.asObservable().subscribe(subscriber);

        callback.getCallback().onClick(null);

        subscriber.assertReceivedOnNext(Lists.newArrayList((Void) null));
    }
}
