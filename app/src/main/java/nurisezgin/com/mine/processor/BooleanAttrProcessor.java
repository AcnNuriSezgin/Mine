package nurisezgin.com.mine.processor;

import android.content.Context;
import android.support.annotation.BoolRes;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.OptionalResources;
import nurisezgin.com.mine.ann.BooleanAttr;

import static nurisezgin.com.mine.ann.Constants.NON_RES;

/**
 * Created by nuri on 17.08.2018
 */
public final class BooleanAttrProcessor extends BaseProcessor<Boolean> {

    public BooleanAttrProcessor(Context context) {
        super(context);
    }

    @Override
    public AttributeResultValue<Boolean> getValue(Annotation annotation) {
        BooleanAttr ann = (BooleanAttr) annotation;

        int index = ann.value();
        @BoolRes int defId = ann.defResValue();
        boolean defValue;

        if (defId != NON_RES) {
            defValue = OptionalResources.getBoolean(context, defId)
                    .orDefault(() -> false);
        } else {
            defValue = ann.defValue();
        }

        return new AttributeResultValue<>(index, defValue);
    }

}
