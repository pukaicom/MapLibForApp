package pk.com.lib.map.navi;

import android.content.Context;

import com.amap.api.maps.AMap;

import java.util.List;

import pk.com.lib.map.modle.PKLatLng;


/**
 * Created by pukai on 16/12/22.
 */
public class AMapNavi extends INavi<AMap>{
    public AMapNavi(AMap aMap, Context context){
        initMapResource(aMap,context);
    }
    @Override
    public void startNavi(PKLatLng fiveStart, PKLatLng fiveEnd, List<PKLatLng> fivePassList) {
    }

    @Override
    public void stopNavi() {
    }
}
