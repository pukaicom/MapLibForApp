package pk.com.lib.map.modle;

import com.amap.api.maps.model.MarkerOptions;

/**
 * Created by pukai on 16/5/20.
 */
public class PKMarkerOptions {
    private MarkerOptions amapMarkerOptions;

    public MarkerOptions getAmapMarkerOptions() {
        return amapMarkerOptions;
    }

    public void setAmapMarkerOptions(MarkerOptions amapMarkerOptions) {
        this.amapMarkerOptions = amapMarkerOptions;
    }
    public PKMarkerOptions(MarkerOptions amapMarkerOptions) {
        this.amapMarkerOptions = amapMarkerOptions;
    }
}
