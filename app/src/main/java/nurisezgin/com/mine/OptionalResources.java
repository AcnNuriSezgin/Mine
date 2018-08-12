package nurisezgin.com.mine;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

import polanski.option.Option;

public class OptionalResources {

    public Option<String> getString(Context context, @StringRes int id) {
        return Option.tryAsOption(() -> context.getString(id));
    }

    public Option<String> getString(Context context, @StringRes int id, String... args) {
        return Option.tryAsOption(() -> context.getString(id, args));
    }

    public Option<Integer> getInteger(Context context, @IntegerRes int id) {
        return Option.tryAsOption(() -> context.getResources().getInteger(id));
    }

    public Option<Boolean> getBoolean(Context context, @BoolRes int id) {
        return Option.tryAsOption(() -> context.getResources().getBoolean(id));
    }

    public static Option<String[]> getStrings(Context context, @ArrayRes int id) {
        return Option.tryAsOption(() -> context.getResources().getStringArray(id));
    }

    public static Option<int[]> getIntegers(Context context, @ArrayRes int id) {
        return Option.tryAsOption(() -> context.getResources().getIntArray(id));
    }

    public static Option<Integer> getColor(Context context, @ColorRes int id) {
        return Option.tryAsOption(() -> ContextCompat.getColor(context, id));
    }

    public static Option<Drawable> getDrawable(Context context, @DrawableRes int id) {
        return Option.tryAsOption(() -> ContextCompat.getDrawable(context, id));
    }
}
