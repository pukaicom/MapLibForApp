package pk.com.lib;

import java.util.List;

import pk.com.lib.map.modle.PKLatLng;

/**
 * Created by pukai on 16/12/19.
 */
public interface CommonMapFunction {
    void setMapCenter(PKLatLng fiveLatLng);

    void addBusinessMarker(PKLatLng fiveLatLng, String title);

    void addPollyLine(List<PKLatLng> fiveLatLngList);

    void moveMap(List<PKLatLng> fiveLatLngList);
}


