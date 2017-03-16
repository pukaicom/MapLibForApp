package pk.com.lib.map.modle;

import com.amap.api.maps.model.Marker;

/**
 * Created by pukai on 2016-4-27.
 * <p/>
 * 用于传递地图标注的公共标注类
 */
public class FiveMarker {
    private Marker amapMarker;

    public FiveMarker(Marker amapMarker) {
        this.amapMarker = amapMarker;
    }


    public void remove() {
        if(amapMarker!=null){
            amapMarker.remove();
        }
    }
    public Marker getAmaptMarker(){
        return amapMarker;
    }
}
