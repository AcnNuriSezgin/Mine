package nurisezgin.com.mine.processor;

import android.content.Context;
import android.support.annotation.IntegerRes;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.OptionalResources;
import nurisezgin.com.mine.ann.FloatAttr;

import static nurisezgin.com.mine.ann.Constants.NON_RES;

/**
 * Created by nuri on 17.08.2018
 */
public final class FloatAttrProcessor extends BaseProcessor<Float> {

    public FloatAttrProcessor(Context context) {
        super(context);
    }

    @Override
    public AttributeResultValue<Float> getValue(Annotation annotation) {
        FloatAttr ann = (FloatAttr) annotation;

        int index = ann.value();
        @IntegerRes int defId = ann.defResValue();
        float defValue;

        if (defId != NON_RES) {
            defValue = OptionalResources.getFloat(context, defId)
                    .orDefault(() -> 0f);
        } else {
            defValue = ann.defValue();
        }

        return new AttributeResultValue<>(index, defValue);
    }
}
