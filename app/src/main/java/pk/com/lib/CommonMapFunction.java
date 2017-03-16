package pk.com.lib;

import java.util.List;

import pk.com.lib.map.modle.FiveLatLng;

/**
 * Created by pukai on 16/12/19.
 */
public interface CommonMapFunction {
    void setMapCenter(FiveLatLng fiveLatLng);

    void addBusinessMarker(FiveLatLng fiveLatLng, String title);

    void addPollyLine(List<FiveLatLng> fiveLatLngList);

    void moveMap(List<FiveLatLng> fiveLatLngList);
}


