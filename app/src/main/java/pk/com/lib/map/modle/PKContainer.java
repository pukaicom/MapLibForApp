package pk.com.lib.map.modle;

/**
 * Created by pukai on 16/12/29.
 */
public class PKContainer<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PKContainer(T data){
        this.data = data;
    }
}
