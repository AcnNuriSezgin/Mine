package nurisezgin.com.mine;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;

import polanski.option.Option;

import static polanski.option.Option.tryAsOption;

public final class OptionalResources {

    public static Option<String> getString(Context context, @StringRes int id) {
        return tryAsOption(() -> context.getString(id));
    }

    public static Option<String> getString(Context context, @StringRes int id, String... args) {
        return tryAsOption(() -> context.getString(id, args));
    }

    public static Option<Float> getFloat(Context context, @IntegerRes int id) {
        return tryAsOption(() -> _getFloat(context, id));
    }

    @NonNull
    private static Float _getFloat(Context context, @IntegerRes int id) {
        TypedValue value = new TypedValue();
        context.getResources().getValue(id, value, true);
        return value.getFloat();
    }

    public static Option<Integer> getInteger(Context context, @IntegerRes int id) {
        return tryAsOption(() -> context.getResources().getInteger(id));
    }

    public static Option<Boolean> getBoolean(Context context, @BoolRes int id) {
        return tryAsOption(() -> context.getResources().getBoolean(id));
    }

    public static Option<Integer> getDimension(Context context, @DimenRes int id) {
        return tryAsOption(() -> context.getResources().getDimensionPixelSize(id));
    }

    public static Option<String[]> getStrings(Context context, @ArrayRes int id) {
        return tryAsOption(() -> context.getResources().getStringArray(id));
    }

    public static Option<int[]> getIntegers(Context context, @ArrayRes int id) {
        return tryAsOption(() -> context.getResources().getIntArray(id));
    }

    public static Option<Integer> getColor(Context context, @ColorRes int id) {
        return tryAsOption(() -> ContextCompat.getColor(context, id));
    }

    public static Option<Drawable> getDrawable(Context context, @DrawableRes int id) {
        return tryAsOption(() -> ContextCompat.getDrawable(context, id));
    }
}
