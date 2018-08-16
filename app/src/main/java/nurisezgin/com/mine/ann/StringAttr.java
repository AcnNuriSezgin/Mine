package nurisezgin.com.mine.ann;

import android.support.annotation.StringRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nuri on 16.08.2018
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StringAttr {

    int value();

    @StringRes int defResValue() default 0;

    boolean useRes() default true;

    String defValue() default "";
}
