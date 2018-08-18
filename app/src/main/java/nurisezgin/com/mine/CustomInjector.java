package nurisezgin.com.mine;

import java.lang.reflect.Field;

import nurisezgin.com.mine.processor.AttributeResultValue;

/**
 * Created by nuri on 17.08.2018
 */
public interface CustomInjector {

    void inject(Object thiz, Field field, AttributeResultValue<?> data);

}
