package net.kr9ly.rxproperty;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Copyright 2016 kr9ly
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class RxCallback<T, V> {

    private final Func<T, V> func;

    private final Object proxy;

    private final Subject<V, V> subject;

    public RxCallback(Func<T, V> adapterFunc, Class<T> bridgeClass) {
        this(adapterFunc, bridgeClass, BehaviorSubject.<V>create());
    }

    public RxCallback(Func<T, V> adapterFunc, Class<T> bridgeClass, Subject<V, V> subject) {
        this.subject = subject;
        this.func = adapterFunc;
        proxy = Proxy.newProxyInstance(bridgeClass.getClassLoader(), new Class[]{bridgeClass}, new IHandler());
    }

    public Observable<V> asObservable() {
        return subject;
    }

    @SuppressWarnings("unchecked")
    @Deprecated
    public T getCallback() {
        return (T) proxy;
    }

    private class IHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            VContainer<V> container = new VContainer<V>();
            T call = func.call(container);
            Object result = method.invoke(call, args);
            if (container.updated) {
                subject.onNext(container.value);
            }
            return result;
        }
    }

    public interface Func<T, V> {
        T call(VContainer<V> container);
    }

    public static class VContainer<V> {

        private boolean updated;

        private V value;

        public void resolve(V value) {
            this.value = value;
            updated = true;
        }
    }
}