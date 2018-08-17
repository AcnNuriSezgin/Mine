package nurisezgin.com.mine.processor;

/**
 * Created by nuri on 17.08.2018
 */
public final class ResultValue<T> {

    private final int index;
    private final T _default;

    public ResultValue(int index, T _default) {
        this.index = index;
        this._default = _default;
    }

    public int getIndex() {
        return index;
    }

    public T getDefault() {
        return _default;
    }
}
