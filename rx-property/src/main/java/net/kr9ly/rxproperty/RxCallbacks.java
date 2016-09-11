package net.kr9ly.rxproperty;

import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;

import net.kr9ly.rxproperty.callback.RxOnAfterTextChangeCallback;
import net.kr9ly.rxproperty.callback.RxOnCheckedChangeCallback;
import net.kr9ly.rxproperty.callback.RxOnClickCallback;
import net.kr9ly.rxproperty.callback.RxOnFocusChangeCallback;
import net.kr9ly.rxproperty.callback.RxOnItemClickCallback;
import net.kr9ly.rxproperty.callback.RxOnItemLongClickCallback;
import net.kr9ly.rxproperty.callback.RxOnItemSelectCallback;
import net.kr9ly.rxproperty.callback.RxOnLongClickCallback;

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
@BindingMethods({
        @BindingMethod(type = View.class, attribute = "onLongClick", method = "setOnLongClickListener"),
        @BindingMethod(type = View.class, attribute = "onFocusChange", method = "setOnFocusChangeListener"),
        @BindingMethod(type = EditText.class, attribute = "onTextChange", method = "addTextChangedListener"),
        @BindingMethod(type = CompoundButton.class, attribute = "onCheckedChange", method = "setOnCheckedChangeListener"),
        @BindingMethod(type = AdapterView.class, attribute = "onItemClick", method = "setOnItemClickListener"),
        @BindingMethod(type = AdapterView.class, attribute = "onItemLongClick", method = "setOnItemLongClickListener"),
        @BindingMethod(type = AdapterView.class, attribute = "onItemSelect", method = "setOnItemSelectedListener")
})
public class RxCallbacks {

    public static RxOnClickCallback onClick() {
        return new RxOnClickCallback();
    }

    public static RxOnLongClickCallback onLongClick() {
        return new RxOnLongClickCallback();
    }

    public static RxOnFocusChangeCallback onFocusChange() {
        return new RxOnFocusChangeCallback();
    }

    public static RxOnAfterTextChangeCallback onAfterTextChange() {
        return new RxOnAfterTextChangeCallback();
    }

    public static RxOnCheckedChangeCallback onCheckedChange() {
        return new RxOnCheckedChangeCallback();
    }

    public static RxOnItemClickCallback onItemClick() {
        return new RxOnItemClickCallback();
    }

    public static RxOnItemLongClickCallback onItemLongClick() {
        return new RxOnItemLongClickCallback();
    }

    public static RxOnItemSelectCallback onItemSelect() {
        return new RxOnItemSelectCallback();
    }
}
