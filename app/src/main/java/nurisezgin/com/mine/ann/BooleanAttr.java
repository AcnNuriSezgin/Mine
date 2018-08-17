package nurisezgin.com.mine.ann;

import android.support.annotation.BoolRes;

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
public @interface BooleanAttr {

    int value();

    @BoolRes int defResValue() default NON_RES;

    boolean defValue() default false;

}
