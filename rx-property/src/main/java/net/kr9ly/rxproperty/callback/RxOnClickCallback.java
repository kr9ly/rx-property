package net.kr9ly.rxproperty.callback;

import android.view.View;

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
public class RxOnClickCallback extends RxCallback<View.OnClickListener, Void> {

    public RxOnClickCallback() {
        super(new Func<View.OnClickListener, Void>() {
            @Override
            public View.OnClickListener call(final VContainer<Void> container) {
                return new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        container.resolve(null);
                    }
                };
            }
        }, View.OnClickListener.class);
    }
}
