package com.sample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import nurisezgin.com.mine.DrawableLoader;
import nurisezgin.com.mine.StyleableAttributes;
import nurisezgin.com.mine.ann.BooleanAttr;
import nurisezgin.com.mine.ann.ColorAttr;
import nurisezgin.com.mine.ann.DimensionAttr;
import nurisezgin.com.mine.ann.DrawableAttr;
import nurisezgin.com.mine.ann.FloatAttr;
import nurisezgin.com.mine.ann.IdAttr;
import nurisezgin.com.mine.ann.IntAttr;
import nurisezgin.com.mine.ann.StringAttr;

/**
 * Created by nuri on 17.08.2018
 */
public class SampleViewWithNonRes extends View implements DrawableLoader {

    @BooleanAttr(value = R.styleable.Sample_boolval, useRes = false, defValue = true)
    private boolean booleanVal;
    @ColorAttr(value = R.styleable.Sample_colorval, useRes = false, defValue = Color.RED)
    private int colorVal;
    @DimensionAttr(value = R.styleable.Sample_dimenval, useRes = false, defValue = 2)
    private int dimenVal;
    @DrawableAttr(value = R.styleable.Sample_drawableval, useRes = false, defValueRequestId = 2)
    private Drawable drawableVal;
    @FloatAttr(value = R.styleable.Sample_floatval, useRes = false, defResValue = R.integer.opt_float)
    private float floatVal;
    @IdAttr(value = R.styleable.Sample_idval, defResValue = R.id.sample_view)
    private int idVal;
    @IntAttr(value = R.styleable.Sample_intval, useRes = false, defValue = 92)
    private int enumVal;
    @StringAttr(value = R.styleable.Sample_stringval, useRes = false, defValue = "absc")
    private String stringVal;

    public SampleViewWithNonRes(Context context) {
        super(context);
        init(null);
    }

    public SampleViewWithNonRes(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SampleViewWithNonRes(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray arr = null;

        if (attrs != null) {
            arr = getContext().obtainStyledAttributes(attrs, R.styleable.Sample);
        }

        StyleableAttributes.inject(this, getContext(), arr, this);
    }

    @Override
    public Drawable loadDrawable(int requestId) {
        return new ColorDrawable(Color.MAGENTA);
    }
}
