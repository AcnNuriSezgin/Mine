package nurisezgin.com.mine.processor;

import android.content.Context;
import android.support.annotation.DimenRes;
import android.support.annotation.Px;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.OptionalResources;
import nurisezgin.com.mine.ann.DimensionAttr;

import static nurisezgin.com.mine.ann.Constants.NON_RES;

/**
 * Created by nuri on 17.08.2018
 */
public final class DimensionAttrProcessor extends BaseProcessor<Integer> {

    public DimensionAttrProcessor(Context context) {
        super(context);
    }

    @Override
    public AttributeResultValue<Integer> getValue(Annotation annotation) {
        DimensionAttr ann = (DimensionAttr) annotation;
        int index = ann.value();
        @DimenRes int defId = ann.defResValue();
        @Px int defValue;

        if (defId != NON_RES) {
            defValue = OptionalResources.getDimension(context, defId)
                    .orDefault(() -> 0);
        } else {
            defValue = ann.defValue();
        }

        return new AttributeResultValue<>(index, defValue);
    }
}
