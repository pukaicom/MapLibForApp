package pk.com.lib.map.navi;

import android.content.Context;

import com.amap.api.maps.AMap;

import java.util.List;

import pk.com.lib.map.modle.FiveLatLng;


/**
 * Created by pukai on 16/12/22.
 */
public class AMapNavi extends INavi<AMap>{
    public AMapNavi(AMap aMap, Context context){
        initMapResource(aMap,context);
    }
    @Override
    public void startNavi(FiveLatLng fiveStart, FiveLatLng fiveEnd, List<FiveLatLng> fivePassList) {
    }

    @Override
    public void stopNavi() {
    }
}
