package pk.com.lib.map.navi;

import java.util.List;

import pk.com.lib.map.MapResource;
import pk.com.lib.map.modle.FiveLatLng;

/**
 * Created by pukai on 16/12/21.
 */
public abstract class INavi<T> extends MapResource<T> {
    abstract void startNavi(FiveLatLng fiveStart, FiveLatLng fiveEnd, List<FiveLatLng> fivePassList);

    abstract void stopNavi();
}