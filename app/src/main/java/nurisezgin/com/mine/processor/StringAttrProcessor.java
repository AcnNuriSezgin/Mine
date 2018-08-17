package nurisezgin.com.mine.processor;

import android.content.Context;
import android.support.annotation.StringRes;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.OptionalResources;
import nurisezgin.com.mine.ann.StringAttr;

import static nurisezgin.com.mine.ann.Constants.NON_RES;

/**
 * Created by nuri on 17.08.2018
 */
public final class StringAttrProcessor extends BaseProcessor<String> {

    public StringAttrProcessor(Context context) {
        super(context);
    }

    @Override
    public AttributeResultValue<String> getValue(Annotation annotation) {
        StringAttr ann = (StringAttr) annotation;

        int index = ann.value();
        @StringRes int defId = ann.defResValue();

        String defValue;
        if (defId != NON_RES) {
            defValue = OptionalResources.getString(context, defId)
                    .orDefault(() -> "");
        } else {
            defValue = ann.defValue();
        }

        return new AttributeResultValue<>(index, defValue);
    }
}
