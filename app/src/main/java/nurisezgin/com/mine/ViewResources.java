package nurisezgin.com.mine;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Px;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import static android.support.v4.content.ContextCompat.getColor;
import static android.support.v4.content.ContextCompat.getDrawable;
import static polanski.option.Option.tryAsOption;

public final class ViewResources {

    public static void setBackgroundColor(View view, @ColorRes int id) {
        Context context = view.getContext();
        @ColorInt int color = getColor(context, id);
        view.setBackgroundColor(color);
    }

    public static void setBackgroundColorRes(View view, @ColorRes int id, @ColorInt int def) {
        Context context = view.getContext();

        view.setBackgroundColor(tryAsOption(() -> getColor(context, id))
                .map(colorInt -> colorInt)
                .orDefault(() -> def));
    }

    public static void setBackgroundColor(View view, @ColorRes int id, @ColorRes int def) {
        Context context = view.getContext();

        view.setBackgroundColor(tryAsOption(() -> getColor(context, id))
                .map(colorInt -> colorInt)
                .orDefault(() -> getColor(context, def)));
    }

    public static void setBackground(View view, @DrawableRes int id) {
        Context context = view.getContext();
        Drawable drawable = getDrawable(context, id);
        setBackground(view, drawable);
    }

    public static void setBackground(View view, @DrawableRes int id, @DrawableRes int def) {
        Context context = view.getContext();

        setBackground(view, tryAsOption(() -> getDrawable(context, id))
                .map(drawable -> drawable)
                .orDefault(() -> getDrawable(context, def)));
    }

    public static void setBackground(View view, @DrawableRes int id, Drawable def) {
        Context context = view.getContext();

        setBackground(view, tryAsOption(() -> getDrawable(context, id))
                .map(drawable -> drawable)
                .orDefault(() -> def));
    }

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void setTextColor(TextView view, @ColorRes int id) {
        @ColorInt int textColor = getColor(view.getContext(), id);
        view.setTextColor(textColor);
    }

    public static void setTextColorRes(TextView view, @ColorRes int id, @ColorRes int def) {
        Context context = view.getContext();
        view.setTextColor(tryAsOption(() -> getColor(context, id))
                .map(colorInt -> colorInt)
                .orDefault(() -> getColor(context, def)));
    }

    public static void setTextColor(TextView view, @ColorRes int id, @ColorInt int def) {
        Context context = view.getContext();
        view.setTextColor(tryAsOption(() -> getColor(context, id))
                .map(colorInt -> colorInt)
                .orDefault(() -> def));
    }

    public static void setTextSize(TextView view, @DimenRes int id) {
        Context context = view.getContext();
        float size = context.getResources().getDimension(id);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public static void setTextSize(TextView view, @DimenRes int id, @DimenRes int def) {
        Context context = view.getContext();
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                tryAsOption(() -> context.getResources().getDimension(id))
                .map(size -> size)
                .orDefault(() -> context.getResources().getDimension(def)));
    }

    public static void setTextSize(TextView view, @DimenRes int id, float def) {
        Context context = view.getContext();
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                tryAsOption(() -> context.getResources().getDimension(id))
                .map(size -> size)
                .orDefault(() -> def));
    }

    public static void setTextSizeAsPixel(TextView view, @Px int size) {
        Context context = view.getContext();
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }
}
