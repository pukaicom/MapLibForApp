package pk.com.lib.map.modle;

/**
 * Created by pukai on 17/2/14.
 */
public class PKMarkerHolder {
    public PKMarkerHolder(PKLatLng latLng, String t, int s) {
        fiveLatLng = latLng;
        title = t;
        status = s;
    }

    public PKLatLng fiveLatLng;
    public String title;
    public int status;
}
