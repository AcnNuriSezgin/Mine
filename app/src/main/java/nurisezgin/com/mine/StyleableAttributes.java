package nurisezgin.com.mine;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import nurisezgin.com.mine.ann.BooleanAttr;
import nurisezgin.com.mine.ann.ColorAttr;
import nurisezgin.com.mine.ann.DimensionAttr;
import nurisezgin.com.mine.ann.DrawableAttr;
import nurisezgin.com.mine.ann.FloatAttr;
import nurisezgin.com.mine.ann.IdAttr;
import nurisezgin.com.mine.ann.IntAttr;
import nurisezgin.com.mine.ann.StringAttr;
import nurisezgin.com.mine.processor.BooleanAttrProcessor;
import nurisezgin.com.mine.processor.ColorAttrProcessor;
import nurisezgin.com.mine.processor.DimensionAttrProcessor;
import nurisezgin.com.mine.processor.DrawableAttrProcessor;
import nurisezgin.com.mine.processor.FloatAttrProcessor;
import nurisezgin.com.mine.processor.IdAttrProcessor;
import nurisezgin.com.mine.processor.IntAttrProcessor;
import nurisezgin.com.mine.processor.AttributeResultValue;
import nurisezgin.com.mine.processor.StringAttrProcessor;

/**
 * Created by nuri on 16.08.2018
 */
public final class StyleableAttributes {

    public static void inject(
            @NonNull Object thiz, @NonNull Context context, @Nullable TypedArray arr) {

        inject(thiz, context, arr, new DrawableLoader.Empty());
    }

    public static void inject(
            @NonNull Object thiz, @NonNull Context context,
            @Nullable TypedArray arr, @NonNull DrawableLoader drawableLoader) {

        Field[] fields = thiz.getClass().getDeclaredFields();

        AttributeValues attrValues = arr != null
                ? new TypedArrayAttributeValues(arr)
                : new AttributeValues.Default();

        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            Annotation[] annotations = field.getAnnotations();
            for (Annotation ann : annotations) {
                try {
                    if (ann instanceof BooleanAttr) {
                        AttributeResultValue<Boolean> res = new BooleanAttrProcessor(context).getValue(ann);
                        boolean value = attrValues.getBoolean(res.getIndex(), res.getDefault());
                        field.set(thiz, value);
                    } else if (ann instanceof ColorAttr) {
                        AttributeResultValue<Integer> res = new ColorAttrProcessor(context).getValue(ann);
                        @ColorInt int value = attrValues.getColor(res.getIndex(), res.getDefault());
                        field.set(thiz, value);
                    } else if (ann instanceof DimensionAttr) {
                        AttributeResultValue<Integer> res = new DimensionAttrProcessor(context).getValue(ann);
                        @Px int value = attrValues.getDimensionAsPixel(res.getIndex(), res.getDefault());
                        field.set(thiz, value);
                    }  else if (ann instanceof DrawableAttr) {
                        AttributeResultValue<Drawable> res = new DrawableAttrProcessor(context, drawableLoader)
                                .getValue(ann);
                        Drawable value = attrValues.getDrawable(res.getIndex(), res.getDefault());
                        field.set(thiz, value);
                    } else if (ann instanceof FloatAttr) {
                        AttributeResultValue<Float> res = new FloatAttrProcessor(context).getValue(ann);
                        float value = attrValues.getFloat(res.getIndex(), res.getDefault());
                        field.set(thiz, value);
                    } else if (ann instanceof IdAttr) {
                        AttributeResultValue<Integer> res = new IdAttrProcessor(context).getValue(ann);
                        int value = attrValues.getResourceId(res.getIndex(), res.getDefault());
                        field.set(thiz, value);
                    } else if (ann instanceof IntAttr) {
                        AttributeResultValue<Integer> res = new IntAttrProcessor(context).getValue(ann);
                        int value = attrValues.getInt(res.getIndex(), res.getDefault());
                        field.set(thiz, value);
                    } else if (ann instanceof StringAttr) {
                        AttributeResultValue<String> res = new StringAttrProcessor(context).getValue(ann);
                        String value = attrValues.getString(res.getIndex(), res.getDefault());
                        field.set(thiz, value);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        attrValues.recycle();
    }

}
