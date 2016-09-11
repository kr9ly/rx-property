package net.kr9ly.rxproperty.callback;

import android.view.View;
import android.widget.AdapterView;

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
public class RxOnItemClickCallback extends RxCallback<AdapterView.OnItemClickListener, RxOnItemClickCallback.ClickedItem> {

    public RxOnItemClickCallback() {
        super(new Func<AdapterView.OnItemClickListener, ClickedItem>() {
            @Override
            public AdapterView.OnItemClickListener call(final VContainer<ClickedItem> container) {
                return new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        container.resolve(new ClickedItem(i, l));
                    }
                };
            }
        }, AdapterView.OnItemClickListener.class);
    }

    public static class ClickedItem {

        private int position;

        private long id;

        public ClickedItem(int position, long id) {
            this.position = position;
            this.id = id;
        }

        public int getPosition() {
            return position;
        }

        public long getId() {
            return id;
        }
    }
}
