package nurisezgin.com.mine;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Px;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public final class ViewResources {

    public static void setBackgroundColor(View view, @ColorRes int id) {
        Context context = view.getContext();
        @ColorInt int color = ContextCompat.getColor(context, id);
        view.setBackgroundColor(color);
    }

    public static void setBackground(View view, @DrawableRes int id) {
        Context context = view.getContext();
        Drawable drawable = ContextCompat.getDrawable(context, id);
        setBackground(view, drawable);
    }

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void setTextColor(TextView view, @ColorRes int color) {
        @ColorInt int textColor = ContextCompat.getColor(view.getContext(), color);
        view.setTextColor(textColor);
    }

    public static void setTextSize(TextView view, @DimenRes int id) {
        Context context = view.getContext();
        float size = context.getResources().getDimension(id);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public static void setTextSizeAsPixel(TextView view, @Px int size) {
        Context context = view.getContext();
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }
}
