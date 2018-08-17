package nurisezgin.com.mine.processor;

import android.content.Context;
import android.support.annotation.DimenRes;
import android.support.annotation.Px;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.OptionalResources;
import nurisezgin.com.mine.ann.DimensionAttr;

/**
 * Created by nuri on 17.08.2018
 */
public final class DimensionAttrProcessor extends BaseProcessor<Integer> {

    public DimensionAttrProcessor(Context context) {
        super(context);
    }

    @Override
    public ResultValue<Integer> getValue(Annotation annotation) {
        DimensionAttr ann = (DimensionAttr) annotation;
        int index = ann.value();
        @DimenRes int defId = ann.defResValue();
        boolean useRes = ann.useRes();
        @Px int defValue;

        if (useRes) {
            defValue = OptionalResources.getDimension(context, defId)
                    .orDefault(() -> 0);
        } else {
            defValue = ann.defValue();
        }

        return new ResultValue<>(index, defValue);
    }
}
