# Mine
Mine gives some quick ways for accessing Android Resources.

## Prerequisites
First, dependency must be added to build.gradle file.
```groovy
implementation 'nurisezgin.com.mine:mine:1.0.0'
```

## How To Use

### Styleables
* Create a custom view and add your layout resources or programmatically getting an instance
for custom view. All custom attributes are injected when call StyleableAttributes.inject method.

```java
    public class SampleView extends View {

        @BooleanAttr(value = R.styleable.Sample_boolval, defResValue = R.bool.defBool)
        private boolean booleanVal;
        @ColorAttr(value = R.styleable.Sample_colorval, defResValue = R.color.color_opt_red)
        private int colorVal;
        @DimensionAttr(value = R.styleable.Sample_dimenval, defResValue = R.dimen.opt_size)
        private int dimenVal;
        @DrawableAttr(value = R.styleable.Sample_drawableval, defResValue = R.drawable.opt_sample_background)
        private Drawable drawableVal;
        @FloatAttr(value = R.styleable.Sample_floatval, defResValue = R.integer.opt_float)
        private float floatVal;
        @IdAttr(value = R.styleable.Sample_idval, defResValue = R.id.sample_view)
        private int idVal;
        @IntAttr(value = R.styleable.Sample_intval, defResValue = R.integer.opt_int)
        private int enumVal;
        @StringAttr(value = R.styleable.Sample_stringval, defResValue = R.string.opt_appname)
        private String stringVal;

        public SampleView(Context context) {
            super(context);
            init(null);
        }

        public SampleView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            init(attrs);
        }

        public SampleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(attrs);
        }

        private void init(AttributeSet attrs) {
            TypedArray arr = null;

            if (attrs != null) {
                arr = getContext().obtainStyledAttributes(attrs, R.styleable.Sample);
            }

            StyleableAttributes.inject(this, getContext(), arr);
        }
    }

```
* Add custom view to layout xml file.
```xml
    <com.sample.SampleView
        android:id="@+id/sample_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#ff0000"
        app:boolval="true"
        app:colorval="@color/color_red"
        app:dimenval="@dimen/size"
        app:drawableval="@drawable/sample_background"
        app:floatval="1.2"
        app:idval="@+id/text_view"
        app:intval="one"
        app:stringval="@string/app_name"/>
```

* Default values, if no value is presented, the attribute will be getting default that is given with
field annotation declaration.
```java
    SampleView def_view = new SampleView(this);
```

* CustomAttr annotation can be used for custom fields. **CustomProcessor** and **Injector** classes
must keep on proguard config file.
```java
    @CustomAttr(processor = CustomProcessor.class, injector = Injector.class)
    private int value;

    public static class CustomProcessor extends BaseProcessor<Object> {

        public CustomProcessor(Context context) {
            super(context);
        }

        @Override
        public AttributeResultValue<Object> getValue(Annotation annotation) {
            return new AttributeResultValue<>(0, "abc");
        }
    }

    public static class Injector implements CustomInjector {

        @Override
        public void inject(Object thiz, Field field, AttributeResultValue<?> data) {
            String def = data.getDefault().toString();
            char[] arr = def.toCharArray();
            int val = 0;
            for (char a: arr) {
                val += (int) a;
            }

            try {
                field.set(thiz, val);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
```

### Optional Resources

Can access to resources those are inside of current project and get result
as a Optional. (Thanks [Tomasz Polanski](https://github.com/tomaszpolanski) for helpful [library](https://github.com/tomaszpolanski/Options))
The Resource Not Found Exception is prevented with OptionalResources and can act
second option like that if it has exception should continue with this.

### View Resources

Some utility methods for setting resource values to views.

## Authors
* **Nuri SEZGIN**-[Email](acnnurisezgin@gmail.com)

## Licence

```
Copyright 2018 Nuri SEZGİN

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