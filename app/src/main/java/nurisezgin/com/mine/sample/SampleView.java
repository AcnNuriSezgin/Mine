package nurisezgin.com.mine.sample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import nurisezgin.com.mine.R;
import nurisezgin.com.mine.StyleableAttributes;
import nurisezgin.com.mine.ann.BooleanAttr;
import nurisezgin.com.mine.ann.ColorAttr;
import nurisezgin.com.mine.ann.DimensionAttr;
import nurisezgin.com.mine.ann.DrawableAttr;
import nurisezgin.com.mine.ann.FloatAttr;
import nurisezgin.com.mine.ann.IdAttr;
import nurisezgin.com.mine.ann.IntAttr;
import nurisezgin.com.mine.ann.StringAttr;

/**
 * Created by nuri on 16.08.2018
 */
public class SampleView extends View {

    @BooleanAttr(value = R.styleable.Sample_boolval, defResValue = R.bool.defBool)
    private boolean booleanVal;
    @ColorAttr(value = R.styleable.Sample_colorval, defResValue = R.color.color_opt_red)
    private int colorVal;
    @DimensionAttr(value = R.styleable.Sample_dimenval, defResValue = R.dimen.opt_size)
    private int dimenVal;
    @DrawableAttr(value = R.styleable.Sample_drawableval, defResValue = R.drawable.opt_sample_background)
    private Drawable drawableVal;
    @FloatAttr(value = R.styleable.Sample_floatval, defResValue = R.integer.opt_float)
    private float floatVal;
    @IdAttr(value = R.styleable.Sample_idval, defResValue = R.id.sample_view)
    private int idVal;
    @IntAttr(value = R.styleable.Sample_intval, defResValue = R.integer.opt_int)
    private int enumVal;
    @StringAttr(value = R.styleable.Sample_stringval, defResValue = R.string.opt_appname)
    private String stringVal;

    public SampleView(Context context) {
        super(context);
        init(null);
    }

    public SampleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SampleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.Sample);
            StyleableAttributes.inject(this, getContext(), arr);
            arr.recycle();
        }
    }
}
