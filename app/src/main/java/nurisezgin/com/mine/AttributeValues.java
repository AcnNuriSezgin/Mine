package nurisezgin.com.mine;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Px;

/**
 * Created by nuri on 17.08.2018
 */
interface AttributeValues {

    default boolean getBoolean(int index, boolean _default) {
        return _default;
    }

    @ColorInt
    default int getColor(int index, @ColorInt int _default) {
        return _default;
    }

    @Px
    default int getDimensionAsPixel(int index, @Px int _default) {
        return _default;
    }

    default Drawable getDrawable(int index, Drawable _default) {
        return _default;
    }

    default float getFloat(int index, float _default) {
        return _default;
    }

    default int getResourceId(int index, int _default) {
        return _default;
    }

    default int getInt(int index, int _default) {
        return _default;
    }

    default String getString(int index, String _default) {
        return _default;
    }

    default void recycle() { }

    class Default implements AttributeValues { }

}
