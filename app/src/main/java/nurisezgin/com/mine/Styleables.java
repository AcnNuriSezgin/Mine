package nurisezgin.com.mine;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.TypedValue;

public final class Styleables {

    private final Context context;
    private final TypedArray arr;

    private Styleables(Context context, TypedArray arr) {
        this.context = context;
        this.arr = arr;
    }

    public static Styleables with(Context context, TypedArray arr) {
        return new Styleables(context, arr);
    }

    public boolean getBoolean(int index, boolean _default) {
        return arr.getBoolean(index, _default);
    }

    public boolean getBooleanUseRes(int index, @BoolRes int resId) {
        return arr.getBoolean(index, context.getResources().getBoolean(resId));
    }

    public float getFloat(int index, float _default) {
        return arr.getFloat(index, _default);
    }

    public float getFloatUseRes(int index, @DimenRes int resId) {
        TypedValue value = new TypedValue();
        context.getResources().getValue(resId, value, true);
        return getFloat(index, value.getFloat());
    }

    public int getInt(int index, int _default) {
        return arr.getInt(index, _default);
    }

    public int getIntUseRes(int index, @IntegerRes int resId) {
        return getInt(index, context.getResources().getInteger(resId));
    }

    public int getDimensionAsPixel(int index, int _default) {
        return arr.getDimensionPixelSize(index, _default);
    }

    public int getDimensionAsPixelUseRes(int index, @DimenRes int resId) {
        return getDimensionAsPixel(index, context.getResources().getDimensionPixelSize(resId));
    }

    public Drawable getDrawable(int index, Drawable _default) {
        Drawable drawable = arr.getDrawable(index);

        if (drawable == null) {
            drawable = _default;
        }

        return drawable;
    }

    public Drawable getDrawableUseRes(int index, @DrawableRes int resId) {
        Drawable drawable = arr.getDrawable(index);

        if (drawable == null) {
            drawable = ContextCompat.getDrawable(context, resId);
        }

        return drawable;
    }

    @ColorInt
    public int getColor(int index, int _default) {
        return arr.getColor(index, _default);
    }

    @ColorInt
    public int getColorUseRes(int index, @ColorRes int resId) {
        int _default = ContextCompat.getColor(context, resId);
        return getColor(index, _default);
    }

    public String getString(int index, String _default) {
        String res = arr.getString(index);

        if (TextUtils.isEmpty(res)) {
            res = _default;
        }

        return res;
    }

    public String getStringUseRes(int index, @StringRes int resId) {
        return getString(index, context.getString(resId));
    }

    public int getResourceId(int index, int _default) {
        return arr.getResourceId(index, _default);
    }
}
