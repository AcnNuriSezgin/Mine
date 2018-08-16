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
import android.support.annotation.IdRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.Px;
import android.support.annotation.StringRes;
import android.text.TextUtils;

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

    // TODO: 16/08/2018 : drawable fetcher with id
    // TODO: 16/08/2018 : refactor add strategy pattern instead multiple if-else
    public static void inject(Object thiz, Context context, TypedArray arr) {
        Field[] fields = thiz.getClass().getDeclaredFields();

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

                        boolean value;
                        if (arr != null) {
                            value = getBoolean(arr, id, defValue);
                        } else {
                            value = defValue;
                        }

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

                        @ColorInt int value;
                        if (arr != null) {
                            value = getColor(arr, id, defValue);
                        } else {
                            value = defValue;
                        }

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

                        @Px int value;
                        if (arr != null) {
                            value = getDimensionAsPixel(arr, id, defValue);
                        } else {
                            value = defValue;
                        }

                        field.set(thiz, value);
                    }  else if (ann instanceof DrawableAttr) {
                        int id = ((DrawableAttr) ann).value();
                        @DrawableRes int defId = ((DrawableAttr) ann).defResValue();
                        Drawable defValue = OptionalResources.getDrawable(context, defId)
                                .orDefault(() -> new ColorDrawable(Color.TRANSPARENT));

                        Drawable value;
                        if (arr != null) {
                            value = getDrawable(arr, id, defValue);
                        } else {
                            value = new ColorDrawable(Color.TRANSPARENT);
                        }

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

                        float value;
                        if (arr != null) {
                            value = getFloat(arr, id, defValue);
                        } else {
                            value = defValue;
                        }

                        field.set(thiz, value);
                    } else if (ann instanceof IdAttr) {
                        int id = ((IdAttr) ann).value();
                        int defValue = ((IdAttr) ann).defResValue();
                        int value;

                        if (arr != null) {
                            value = getResourceId(arr, id, defValue);
                            field.set(thiz, value);
                        }
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

                        int value;
                        if (arr != null) {
                            value = getInt(arr, id, defValue);
                        } else {
                            value = 0;
                        }

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

                        String value;
                        if (arr != null) {
                            value = getString(arr, id, defValue);
                        } else {
                            value = defValue;
                        }

                        field.set(thiz, value);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        arr.recycle();
    }

    public static boolean getBoolean(TypedArray arr, int index, boolean _default) {
        return arr.getBoolean(index, _default);
    }

    @ColorInt
    public static int getColor(TypedArray arr, int index, @ColorInt int _default) {
        return arr.getColor(index, _default);
    }

    @Px
    public static int getDimensionAsPixel(TypedArray arr, int index, @Px int _default) {
        return arr.getDimensionPixelSize(index, _default);
    }

    public static Drawable getDrawable(TypedArray arr, int index, Drawable _default) {
        Drawable drawable = arr.getDrawable(index);

        if (drawable == null) {
            drawable = _default;
        }
        return drawable;
    }

    public static float getFloat(TypedArray arr, int index, float _default) {
        return arr.getFloat(index, _default);
    }

    @IdRes
    public static int getResourceId(TypedArray arr, int index, int _default) {
        return arr.getResourceId(index, _default);
    }

    public static int getInt(TypedArray arr, int index, int _default) {
        return arr.getInt(index, _default);
    }

    public static String getString(TypedArray arr, int index, String _default) {
        String res = arr.getString(index);

        if (TextUtils.isEmpty(res)) {
            res = _default;
        }

        return res;
    }
}
