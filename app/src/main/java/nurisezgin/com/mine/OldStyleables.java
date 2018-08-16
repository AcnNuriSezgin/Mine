package nurisezgin.com.mine;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.text.TextUtils;

@Deprecated
public final class OldStyleables {

    private final Context context;
    private final TypedArray arr;

    private OldStyleables(Context context, TypedArray arr) {
        this.context = context;
        this.arr = arr;
    }

    public static OldStyleables with(Context context, TypedArray arr) {
        return new OldStyleables(context, arr);
    }

    public boolean getBoolean(int index, boolean _default) {
        return arr.getBoolean(index, _default);
    }

    public float getFloat(int index, float _default) {
        return arr.getFloat(index, _default);
    }

    public int getInt(int index, int _default) {
        return arr.getInt(index, _default);
    }

    public int getDimensionAsPixel(int index, int _default) {
        return arr.getDimensionPixelSize(index, _default);
    }

    public Drawable getDrawable(int index, Drawable _default) {
        Drawable drawable = arr.getDrawable(index);

        if (drawable == null) {
            drawable = _default;
        }
        return drawable;
    }

    @ColorInt
    public int getColor(int index, int _default) {
        return arr.getColor(index, _default);
    }

    public String getString(int index, String _default) {
        String res = arr.getString(index);

        if (TextUtils.isEmpty(res)) {
            res = _default;
        }

        return res;
    }

    public int getResourceId(int index, int _default) {
        return arr.getResourceId(index, _default);
    }
}
