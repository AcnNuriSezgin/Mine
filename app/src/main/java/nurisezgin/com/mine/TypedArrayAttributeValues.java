package nurisezgin.com.mine;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/**
 * Created by nuri on 17.08.2018
 */
final class TypedArrayAttributeValues implements AttributeValues {

    private final TypedArray arr;

    TypedArrayAttributeValues(TypedArray arr) {
        this.arr = arr;
    }

    @Override
    public boolean getBoolean(int index, boolean _default) {
        return TypedArrayValues.getBoolean(arr, index, _default);
    }

    @Override
    public int getColor(int index, int _default) {
        return TypedArrayValues.getColor(arr, index, _default);
    }

    @Override
    public int getDimensionAsPixel(int index, int _default) {
        return TypedArrayValues.getDimensionAsPixel(arr, index, _default);
    }

    @Override
    public Drawable getDrawable(int index, Drawable _default) {
        return TypedArrayValues.getDrawable(arr, index, _default);
    }

    @Override
    public float getFloat(int index, float _default) {
        return TypedArrayValues.getFloat(arr, index, _default);
    }

    @Override
    public int getResourceId(int index, int _default) {
        return TypedArrayValues.getResourceId(arr, index, _default);
    }

    @Override
    public int getInt(int index, int _default) {
        return TypedArrayValues.getInt(arr, index, _default);
    }

    @Override
    public String getString(int index, String _default) {
        return TypedArrayValues.getString(arr, index, _default);
    }

    @Override
    public void recycle() {
        arr.recycle();
    }
}
