package nurisezgin.com.mine.ann;

import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static nurisezgin.com.mine.ann.Constants.NON_RES;

/**
 * Created by nuri on 16.08.2018
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColorAttr {

    int value();

    @ColorRes int defResValue() default NON_RES;

    @ColorInt int defValue() default 0;

}
