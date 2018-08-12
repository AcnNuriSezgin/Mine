package nurisezgin.com.mine;

import android.content.Context;
import android.graphics.drawable.Drawable;

import polanski.option.Option;

public abstract class ResourceDelegateImp implements ResourceDelegate {

    protected abstract Context getContext();

    @Override
    public final Option<String> getString(int id) {
        return OptionalResources.getString(getContext(), id);
    }

    @Override
    public final Option<String> getString(int id, String... args) {
        return OptionalResources.getString(getContext(), id, args);
    }

    @Override
    public final Option<Integer> getInteger(int id) {
        return OptionalResources.getInteger(getContext(), id);
    }

    @Override
    public final Option<Boolean> getBoolean(int id) {
        return OptionalResources.getBoolean(getContext(), id);
    }

    @Override
    public final Option<Integer> getDimension(int id) {
        return OptionalResources.getDimension(getContext(), id);
    }

    @Override
    public final Option<String[]> getStrings(int id) {
        return OptionalResources.getStrings(getContext(), id);
    }

    @Override
    public final Option<int[]> getIntegers(int id) {
        return OptionalResources.getIntegers(getContext(), id);
    }

    @Override
    public final Option<Integer> getColor(int id) {
        return OptionalResources.getColor(getContext(), id);
    }

    @Override
    public final Option<Drawable> getDrawable(int id) {
        return OptionalResources.getDrawable(getContext(), id);
    }
}
