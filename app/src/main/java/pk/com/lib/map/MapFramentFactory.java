package pk.com.lib.map;

import android.os.Bundle;

import pk.com.lib.map.gaode.AmapFragment;


/**
 * Created by pukai on 2016-4-26.
 * <p>
 * 地图工厂类，根据CODE创建地图
 */
public class MapFramentFactory {
    public final static int TENCENT_MAP_CODE = 0;
    public final static int GAODE_MAP_CODE = 1;

    public static MapFrament createMapFrament(int mapCode, Bundle bundle) {
        MapFrament mapFrament = null;
        
        if (mapCode == GAODE_MAP_CODE) {
            mapFrament = AmapFragment.newInstance(bundle);
        }
        return mapFrament;
    }
}
