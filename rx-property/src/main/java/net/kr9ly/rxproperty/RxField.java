package net.kr9ly.rxproperty;

import android.databinding.ObservableField;

import rx.Observer;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;
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
public class RxField<V> {

    private ObservableField<V> field;

    private Subject<V, V> subject = BehaviorSubject.create();

    public static <T> RxField<T> create(T initialValue) {
        return new RxField<T>(initialValue);
    }

    public RxField(V initialValue) {
        this.field = new ObservableField<V>();
        subject = BehaviorSubject.create(initialValue);
        subject.subscribe(new Action1<V>() {
            @Override
            public void call(V v) {
                field.set(v);
            }
        });
    }

    public Observer<V> asObserver() {
        return subject;
    }

    @Deprecated
    public ObservableField<V> getValue() {
        return field;
    }
}