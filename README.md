# Rx Property - RxJava Adapter for Android Data Binding

[![Circle CI](https://circleci.com/gh/kr9ly/rx-property/tree/master.svg?style=shield)](https://circleci.com/gh/kr9ly/rx-property/tree/master)

# Dependency

Add this to `repositories` block in your build.gradle

```
jcenter()
```

And Add this to `dependencies` block in your build.gradle

```
compile 'net.kr9ly:rx-property:1.0.0'
```

### Usage

Sample ViewModel

```java
public class SampleViewModel {

    private Context context;

    public SampleViewModel(Context context) {
        this.context = context;
        text.asObservable().map(v -> !TextUtils.isEmpty(v)).subscribe(clickEnabled.asObserver());
        textFocus.asObservable().map(b -> context.getResources().getColor(b ? R.color.activeBg : R.color.inactiveBg)).subscribe(bgColor.asObserver());
        longClick.asObservable().subscribe(v -> Toast.makeText(context, "foo!", Toast.LENGTH_SHORT).show());
        Observable.combineLatest(click.asObservable().map(v -> new Random().nextInt()), text.asObservable(), (c, m) -> "message:" + m + ", count:" + c)
                .subscribe(message.asObserver());
    }

    public final RxField<String> message = RxField.create("");

    public final RxField<Boolean> clickEnabled = RxField.create(false);

    public final RxField<Integer> bgColor = RxField.create(R.color.activeBg);

    public final RxOnClickCallback click = RxCallbacks.onClick();

    public final RxOnLongClickCallback longClick = RxCallbacks.onLongClick();

    public final RxOnAfterTextChangeCallback text = RxCallbacks.onAfterTextChange();

    public final RxOnFocusChangeCallback textFocus = RxCallbacks.onFocusChange();
}
```

Sample layout

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <data>
        <variable
            name="viewModel"
            type="com.example.rxsample.SampleViewModel" />
        </data>
    <LinearLayout xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        tools:context="com.example.rxsample.MainActivity">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{viewModel.message.value}"
            android:id="@+id/label"
            android:background="@{viewModel.bgColor.value}"/>

        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/editText"
            app:onFocusChange="@{viewModel.textFocus.callback}"
            app:onTextChange="@{viewModel.text.callback}"/>

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="change text"
            android:id="@+id/button"
            android:onClick="@{viewModel.click.callback}"
            android:enabled="@{viewModel.clickEnabled.value}"
            app:onLongClick="@{viewModel.longClick.callback}"
            />

    </LinearLayout>
</layout>
```

Callback Sample

```java
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
```
# License

```
Copyright 2016 kr9ly

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```