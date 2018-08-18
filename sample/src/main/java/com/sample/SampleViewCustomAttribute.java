package com.sample;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import nurisezgin.com.mine.CustomInjector;
import nurisezgin.com.mine.StyleableAttributes;
import nurisezgin.com.mine.ann.CustomAttr;
import nurisezgin.com.mine.processor.AttributeResultValue;
import nurisezgin.com.mine.processor.BaseProcessor;

/**
 * Created by nuri on 17.08.2018
 */
public class SampleViewCustomAttribute extends View {

    @CustomAttr(processor = CustomProcessor.class, injector = Injector.class)
    private int value;

    public SampleViewCustomAttribute(Context context) {
        super(context);
        init(null);
    }

    public SampleViewCustomAttribute(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SampleViewCustomAttribute(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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


}
