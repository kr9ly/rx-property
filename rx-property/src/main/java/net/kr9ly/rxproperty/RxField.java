package net.kr9ly.rxproperty;

import rx.Observer;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/**
 * Copyright 2016 kr9ly
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class RxField<V> {

    private SimpleObservable<V> field = new SimpleObservable<V>();

    private Subject<V, V> subject = BehaviorSubject.create();

    public static <T> RxField<T> create(T initialValue) {
        return new RxField<T>(initialValue);
    }

    public RxField(V initialValue) {
        subject = BehaviorSubject.create(initialValue);
        subject.subscribe(field);
    }

    public Observer<V> asObserver() {
        return subject;
    }

    @Deprecated
    public SimpleObservable<V> getValue() {
        return field;
    }
}