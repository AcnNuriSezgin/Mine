package nurisezgin.com.mine.processor;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.DrawableLoader;
import nurisezgin.com.mine.OptionalResources;
import nurisezgin.com.mine.ann.DrawableAttr;

/**
 * Created by nuri on 17.08.2018
 */
public final class DrawableAttrProcessor extends BaseProcessor<Drawable> {

    private final DrawableLoader loader;

    public DrawableAttrProcessor(Context context, DrawableLoader loader) {
        super(context);
        this.loader = loader;
    }

    @Override
    public ResultValue<Drawable> getValue(Annotation annotation) {
        DrawableAttr ann = (DrawableAttr) annotation;

        int index = ann.value();
        @DrawableRes int defId = ann.defResValue();
        boolean useRes = ann.useRes();
        Drawable defValue;

        if (useRes) {
            defValue = OptionalResources.getDrawable(context, defId)
                    .orDefault(() -> new ColorDrawable(Color.TRANSPARENT));
        } else {
            int requestId = ann.defValueRequestId();
            defValue = loader.loadDrawable(requestId);
        }

        return new ResultValue<>(index, defValue);
    }
}
