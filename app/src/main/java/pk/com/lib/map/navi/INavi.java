package pk.com.lib.map.navi;

import java.util.List;

import pk.com.lib.map.MapResource;
import pk.com.lib.map.modle.PKLatLng;

/**
 * Created by pukai on 16/12/21.
 */
public abstract class INavi<T> extends MapResource<T> {
    abstract void startNavi(PKLatLng fiveStart, PKLatLng fiveEnd, List<PKLatLng> fivePassList);

    abstract void stopNavi();
}