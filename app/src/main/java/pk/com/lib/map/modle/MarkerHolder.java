package pk.com.lib.map.modle;

/**
 * Created by pukai on 17/2/14.
 */
public class MarkerHolder {
    public MarkerHolder(FiveLatLng latLng, String t, int s) {
        fiveLatLng = latLng;
        title = t;
        status = s;
    }

    public FiveLatLng fiveLatLng;
    public String title;
    public int status;
}
