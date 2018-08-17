package nurisezgin.com.mine.processor;

import android.content.Context;
import android.support.annotation.StringRes;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.OptionalResources;
import nurisezgin.com.mine.ann.StringAttr;

/**
 * Created by nuri on 17.08.2018
 */
public final class StringAttrProcessor extends BaseProcessor<String> {

    public StringAttrProcessor(Context context) {
        super(context);
    }

    @Override
    public ResultValue<String> getValue(Annotation annotation) {
        StringAttr ann = (StringAttr) annotation;

        int index = ann.value();
        @StringRes int defId = ann.defResValue();
        boolean useRes = ann.useRes();

        String defValue;
        if (useRes) {
            defValue = OptionalResources.getString(context, defId)
                    .orDefault(() -> "");
        } else {
            defValue = ann.defValue();
        }

        return new ResultValue<>(index, defValue);
    }
}
