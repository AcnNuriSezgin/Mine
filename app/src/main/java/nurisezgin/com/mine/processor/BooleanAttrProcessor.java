package nurisezgin.com.mine.processor;

import android.content.Context;
import android.support.annotation.BoolRes;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.OptionalResources;
import nurisezgin.com.mine.ann.BooleanAttr;

/**
 * Created by nuri on 17.08.2018
 */
public final class BooleanAttrProcessor extends BaseProcessor<Boolean> {

    public BooleanAttrProcessor(Context context) {
        super(context);
    }

    @Override
    public ResultValue<Boolean> getValue(Annotation annotation) {
        BooleanAttr ann = (BooleanAttr) annotation;

        int index = ann.value();
        boolean useRes = ann.useRes();
        boolean defValue;

        if (useRes) {
            @BoolRes int defId = ann.defResValue();
            defValue = OptionalResources.getBoolean(context, defId)
                    .orDefault(() -> false);
        } else {
            defValue = ann.defValue();
        }

        return new ResultValue<>(index, defValue);
    }

}
