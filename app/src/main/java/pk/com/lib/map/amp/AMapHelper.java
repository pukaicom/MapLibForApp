package pk.com.lib.map.amp;

import android.content.Context;

import com.amap.api.maps.AMap;

import pk.com.lib.map.MapHelper;
import pk.com.lib.map.control.AMapControl;
import pk.com.lib.map.control.IControl;
import pk.com.lib.map.navi.AMapNavi;
import pk.com.lib.map.navi.INavi;
import pk.com.lib.map.overlay.AMapOverLay;
import pk.com.lib.map.overlay.IOverLay;
import pk.com.lib.map.smooth.AMapSooth;
import pk.com.lib.map.smooth.ISmooth;
import pk.com.lib.map.trace.AMapTrace;
import pk.com.lib.map.trace.ITrace;


/**
 * Created by pukai on 16/12/22.
 */
public class AMapHelper extends MapHelper<AMap> {
    public AMapHelper(AMap aMap,Context context){
        super(aMap,context);
    }
    public INavi createNaive(AMap fiveMap, Context context){
        return new AMapNavi(fiveMap,context);
    }

    @Override
    protected ITrace createTrace(AMap fiveMap, Context context) {
        return new AMapTrace(fiveMap,context);
    }

    @Override
    protected IControl createControl(AMap fiveMap, Context context) {
        return new AMapControl(fiveMap,context);
    }

    @Override
    protected ISmooth createSmooth(AMap fiveMap, Context context) {
        return new AMapSooth(fiveMap,context);
    }

    @Override
    protected IOverLay createOverLay(AMap fiveMap, Context context) {
        return new AMapOverLay(fiveMap,context);
    }
}
