package nurisezgin.com.mine.processor;

import android.content.Context;

import java.lang.annotation.Annotation;

/**
 * Created by nuri on 17.08.2018
 */
public abstract class BaseProcessor<T> {

    protected final Context context;

    public BaseProcessor(Context context) {
        this.context = context;
    }

    public abstract AttributeResultValue<T> getValue(Annotation annotation);

}
