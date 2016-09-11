package net.kr9ly.rxproperty.callback;

import android.text.Editable;
import android.text.TextWatcher;

import net.kr9ly.rxproperty.RxCallback;

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
public class RxOnAfterTextChangeCallback extends RxCallback<TextWatcher, String> {

    public RxOnAfterTextChangeCallback() {
        super(new Func<TextWatcher, String>() {
            @Override
            public TextWatcher call(final VContainer<String> container) {
                return new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        container.resolve(editable.toString());
                    }
                };
            }
        }, TextWatcher.class);
    }
}
