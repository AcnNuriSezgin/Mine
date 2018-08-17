package nurisezgin.com.mine;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by nuri on 17.08.2018
 */
public interface DrawableLoader {

    Drawable loadDrawable(int requestId);

    class Empty implements DrawableLoader {

        @Override
        public Drawable loadDrawable(int requestId) {
            return new ColorDrawable(Color.TRANSPARENT);
        }
    }

}
