package nurisezgin.com.mine;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.annotation.Px;
import android.text.TextUtils;

/**
 * Created by nuri on 17.08.2018
 */
public final class TypedArrayValues {

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
