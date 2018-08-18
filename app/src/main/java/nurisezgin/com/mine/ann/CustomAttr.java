package nurisezgin.com.mine.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import nurisezgin.com.mine.CustomInjector;
import nurisezgin.com.mine.processor.BaseProcessor;

/**
 * Created by nuri on 17.08.2018
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomAttr {

    Class<? extends BaseProcessor<?>> processor();

    Class<? extends CustomInjector> injector();

}
