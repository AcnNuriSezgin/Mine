package nurisezgin.com.mine.processor;

import android.content.Context;

import java.lang.annotation.Annotation;

import nurisezgin.com.mine.ann.IdAttr;

/**
 * Created by nuri on 17.08.2018
 */
public final class IdAttrProcessor extends BaseProcessor<Integer> {

    public IdAttrProcessor(Context context) {
        super(context);
    }

    @Override
    public AttributeResultValue<Integer> getValue(Annotation annotation) {
        IdAttr ann = (IdAttr) annotation;

        int index = ann.value();
        int defValue = ann.defResValue();

        return new AttributeResultValue<>(index, defValue);
    }
}
