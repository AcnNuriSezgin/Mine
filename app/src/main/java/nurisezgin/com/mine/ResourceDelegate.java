package nurisezgin.com.mine;

import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringRes;

import polanski.option.Option;

interface ResourceDelegate {

    Option<String> getString(@StringRes int id);

    Option<String> getString(@StringRes int id, String... args);

    Option<Integer> getInteger(@IntegerRes int id);

    Option<Boolean> getBoolean(@BoolRes int id);

    Option<Integer> getDimension(@DimenRes int id);

    Option<String[]> getStrings(@ArrayRes int id);

    Option<int[]> getIntegers(@ArrayRes int id);

    Option<Integer> getColor(@ColorRes int id);

    Option<Drawable> getDrawable(@DrawableRes int id);

}
