package nurisezgin.com.mine;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.Px;
import android.support.annotation.StringRes;

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
import polanski.option.Option;

/**
 * Created by nuri on 16.08.2018
 */
public final class StyleableAttributes {

    public static void inject(Object thiz, Context context, TypedArray arr) {
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
                        int id = ((BooleanAttr) ann).value();
                        boolean useRes = ((BooleanAttr) ann).useRes();
                        boolean defValue;

                        if (useRes) {
                            @BoolRes int defId = ((BooleanAttr) ann).defResValue();
                            defValue = OptionalResources.getBoolean(context, defId)
                                    .orDefault(() -> false);
                        } else {
                            defValue = ((BooleanAttr) ann).defValue();
                        }

                        boolean value = attrValues.getBoolean(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof ColorAttr) {
                        int id = ((ColorAttr) ann).value();
                        boolean useRes = ((ColorAttr) ann).useRes();
                        @ColorInt int defValue;

                        if (useRes) {
                            @ColorRes int defId = ((ColorAttr) ann).defResValue();
                            defValue = OptionalResources.getColor(context, defId)
                                    .orDefault(() -> Color.TRANSPARENT);
                        } else {
                            defValue = ((ColorAttr) ann).defValue();
                        }

                        defValue = Option.ofObj(defValue)
                                .filter(def -> def != 0)
                                .match(def -> def, () -> Color.TRANSPARENT);

                        @ColorInt int value = attrValues.getColor(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof DimensionAttr) {
                        int id = ((DimensionAttr) ann).value();
                        @DimenRes int defId = ((DimensionAttr) ann).defResValue();
                        boolean useRes = ((DimensionAttr) ann).useRes();
                        @Px int defValue;

                        if (useRes) {
                            defValue = OptionalResources.getDimension(context, defId)
                                    .orDefault(() -> 0);
                        } else {
                            defValue = ((DimensionAttr) ann).defValue();
                        }

                        @Px int value = attrValues.getDimensionAsPixel(id, defValue);
                        field.set(thiz, value);
                    }  else if (ann instanceof DrawableAttr) {
                        int id = ((DrawableAttr) ann).value();
                        @DrawableRes int defId = ((DrawableAttr) ann).defResValue();
                        Drawable defValue = OptionalResources.getDrawable(context, defId)
                                .orDefault(() -> new ColorDrawable(Color.TRANSPARENT));

                        Drawable value = attrValues.getDrawable(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof FloatAttr) {
                        int id = ((FloatAttr) ann).value();
                        @IntegerRes int defId = ((FloatAttr) ann).defResValue();
                        boolean useRes = ((FloatAttr) ann).useRes();
                        float defValue;

                        if (useRes) {
                            defValue = OptionalResources.getFloat(context, defId)
                                    .orDefault(() -> 0f);
                        } else {
                            defValue = ((FloatAttr) ann).defValue();
                        }

                        float value = attrValues.getFloat(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof IdAttr) {
                        int id = ((IdAttr) ann).value();
                        int defValue = ((IdAttr) ann).defResValue();

                        int value = attrValues.getResourceId(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof IntAttr) {
                        int id = ((IntAttr) ann).value();
                        boolean useRes = ((IntAttr) ann).useRes();
                        int defValue;

                        if (useRes) {
                            @IntegerRes int defId = ((IntAttr) ann).defResValue();
                            defValue = OptionalResources.getInteger(context, defId)
                                    .orDefault(() -> 0);
                        } else {
                            defValue = ((IntAttr) ann).defValue();
                        }

                        int value = attrValues.getInt(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof StringAttr) {
                        int id = ((StringAttr) ann).value();
                        @StringRes int defId = ((StringAttr) ann).defResValue();
                        boolean useRes = ((StringAttr) ann).useRes();

                        String defValue;
                        if (useRes) {
                            defValue = OptionalResources.getString(context, defId)
                                    .orDefault(() -> "");
                        } else {
                            defValue = ((StringAttr) ann).defValue();
                        }

                        String value = attrValues.getString(id, defValue);;
                        field.set(thiz, value);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        attrValues.recycle();
    }

    public static void inject(Object thiz, Context context, TypedArray arr, DrawableLoader drawableLoader) {
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
                        int id = ((BooleanAttr) ann).value();
                        boolean useRes = ((BooleanAttr) ann).useRes();
                        boolean defValue;

                        if (useRes) {
                            @BoolRes int defId = ((BooleanAttr) ann).defResValue();
                            defValue = OptionalResources.getBoolean(context, defId)
                                    .orDefault(() -> false);
                        } else {
                            defValue = ((BooleanAttr) ann).defValue();
                        }

                        boolean value = attrValues.getBoolean(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof ColorAttr) {
                        int id = ((ColorAttr) ann).value();
                        boolean useRes = ((ColorAttr) ann).useRes();
                        @ColorInt int defValue;

                        if (useRes) {
                            @ColorRes int defId = ((ColorAttr) ann).defResValue();
                            defValue = OptionalResources.getColor(context, defId)
                                    .orDefault(() -> Color.TRANSPARENT);
                        } else {
                            defValue = ((ColorAttr) ann).defValue();
                        }

                        defValue = Option.ofObj(defValue)
                                .filter(def -> def != 0)
                                .match(def -> def, () -> Color.TRANSPARENT);

                        @ColorInt int value = attrValues.getColor(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof DimensionAttr) {
                        int id = ((DimensionAttr) ann).value();
                        @DimenRes int defId = ((DimensionAttr) ann).defResValue();
                        boolean useRes = ((DimensionAttr) ann).useRes();
                        @Px int defValue;

                        if (useRes) {
                            defValue = OptionalResources.getDimension(context, defId)
                                    .orDefault(() -> 0);
                        } else {
                            defValue = ((DimensionAttr) ann).defValue();
                        }

                        @Px int value = attrValues.getDimensionAsPixel(id, defValue);
                        field.set(thiz, value);
                    }  else if (ann instanceof DrawableAttr) {
                        int id = ((DrawableAttr) ann).value();
                        @DrawableRes int defId = ((DrawableAttr) ann).defResValue();
                        boolean useRes = ((DrawableAttr) ann).useRes();
                        Drawable defValue;

                        if (useRes) {
                            defValue = OptionalResources.getDrawable(context, defId)
                                    .orDefault(() -> new ColorDrawable(Color.TRANSPARENT));
                        } else {
                            int requestId = ((DrawableAttr) ann).defValueRequestId();
                            defValue = drawableLoader.loadDrawable(requestId);
                        }

                        Drawable value = attrValues.getDrawable(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof FloatAttr) {
                        int id = ((FloatAttr) ann).value();
                        @IntegerRes int defId = ((FloatAttr) ann).defResValue();
                        boolean useRes = ((FloatAttr) ann).useRes();
                        float defValue;

                        if (useRes) {
                            defValue = OptionalResources.getFloat(context, defId)
                                    .orDefault(() -> 0f);
                        } else {
                            defValue = ((FloatAttr) ann).defValue();
                        }

                        float value = attrValues.getFloat(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof IdAttr) {
                        int id = ((IdAttr) ann).value();
                        int defValue = ((IdAttr) ann).defResValue();

                        int value = attrValues.getResourceId(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof IntAttr) {
                        int id = ((IntAttr) ann).value();
                        boolean useRes = ((IntAttr) ann).useRes();
                        int defValue;

                        if (useRes) {
                            @IntegerRes int defId = ((IntAttr) ann).defResValue();
                            defValue = OptionalResources.getInteger(context, defId)
                                    .orDefault(() -> 0);
                        } else {
                            defValue = ((IntAttr) ann).defValue();
                        }

                        int value = attrValues.getInt(id, defValue);
                        field.set(thiz, value);
                    } else if (ann instanceof StringAttr) {
                        int id = ((StringAttr) ann).value();
                        @StringRes int defId = ((StringAttr) ann).defResValue();
                        boolean useRes = ((StringAttr) ann).useRes();

                        String defValue;
                        if (useRes) {
                            defValue = OptionalResources.getString(context, defId)
                                    .orDefault(() -> "");
                        } else {
                            defValue = ((StringAttr) ann).defValue();
                        }

                        String value = attrValues.getString(id, defValue);;
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
