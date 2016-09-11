package net.kr9ly.rxproperty.callback;

import android.widget.CompoundButton;

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
public class RxOnCheckedChangeCallback extends RxCallback<CompoundButton.OnCheckedChangeListener, Boolean> {

    public RxOnCheckedChangeCallback() {
        super(new Func<CompoundButton.OnCheckedChangeListener, Boolean>() {
            @Override
            public CompoundButton.OnCheckedChangeListener call(final VContainer<Boolean> container) {
                return new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        container.resolve(b);
                    }
                };
            }
        }, CompoundButton.OnCheckedChangeListener.class);
    }
}
