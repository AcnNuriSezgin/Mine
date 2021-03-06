package nurisezgin.com.mine.processor;

import android.content.Context;
import android.support.annotation.IntegerRes;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.OptionalResources;
import nurisezgin.com.mine.ann.IntAttr;

import static nurisezgin.com.mine.ann.Constants.NON_RES;

/**
 * Created by nuri on 17.08.2018
 */
public final class IntAttrProcessor extends BaseProcessor<Integer> {

    public IntAttrProcessor(Context context) {
        super(context);
    }

    @Override
    public AttributeResultValue<Integer> getValue(Annotation annotation) {
        IntAttr ann = (IntAttr) annotation;

        int index = ann.value();
        @IntegerRes int defId = ann.defResValue();
        int defValue;

        if (defId != NON_RES) {
            defValue = OptionalResources.getInteger(context, defId)
                    .orDefault(() -> 0);
        } else {
            defValue = ann.defValue();
        }

        return new AttributeResultValue<>(index, defValue);
    }
}
