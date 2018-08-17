package nurisezgin.com.mine.processor;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.OptionalResources;
import nurisezgin.com.mine.ann.ColorAttr;
import polanski.option.Option;

import static nurisezgin.com.mine.ann.Constants.NON_RES;

/**
 * Created by nuri on 17.08.2018
 */
public final class ColorAttrProcessor extends BaseProcessor<Integer> {

    public ColorAttrProcessor(Context context) {
        super(context);
    }

    @Override
    public AttributeResultValue<Integer> getValue(Annotation annotation) {
        ColorAttr ann = (ColorAttr) annotation;

        int index = ann.value();
        @ColorRes int defId = ann.defResValue();
        @ColorInt int defValue;

        if (defId != NON_RES) {
            defValue = OptionalResources.getColor(context, defId)
                    .orDefault(() -> Color.TRANSPARENT);
        } else {
            defValue = ann.defValue();
        }

        defValue = Option.ofObj(defValue)
                .filter(def -> def != 0)
                .match(def -> def, () -> Color.TRANSPARENT);

        return new AttributeResultValue<>(index, defValue);
    }
}
