package pk.com.lib.map.overlay;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;


import java.util.List;

import pk.com.lib.map.modle.FiveLatLng;
import pk.com.lib.map.modle.FiveListLatLngContainer;
import pk.com.lib.map.modle.FiveMarker;
import pk.com.lib.map.modle.FiveMarkerOptions;

/**
 * Created by pukai on 16/12/22.
 */
public class AMapOverLay extends IOverLay<AMap> {

    public AMapOverLay(AMap aMap, Context context) {
        initMapResource(aMap, context);
    }

    @Override
    public FiveMarker addMarker(FiveMarkerOptions fiveMarkerOptions) {
        return null;
    }

    @Override
    public FiveMarker addMarker(FiveLatLng fiveLatLng, View view) {
        FiveMarker fiveMarker = new FiveMarker(mFiveMap.addMarker(new MarkerOptions().position(fiveLatLng.getAmapLatlng()).title("")));
        fiveMarker.getAmaptMarker().setIcon(BitmapDescriptorFactory.fromView(view));
        return fiveMarker;
    }

    @Override
    public FiveMarker addMarker(FiveLatLng fiveLatLng, View view, float anchorX, float anchorY) {
        FiveMarker fiveMarker = new FiveMarker(mFiveMap.addMarker(new MarkerOptions().position(fiveLatLng.getAmapLatlng()).title("").anchor(anchorX, anchorY)));
        fiveMarker.getAmaptMarker().setIcon(BitmapDescriptorFactory.fromView(view));
        return fiveMarker;
    }

    @Override
    public FiveMarker addMarker(FiveLatLng fiveLatLng, int imgId) {
        FiveMarker fiveMarker = new FiveMarker(mFiveMap.addMarker(new MarkerOptions()
                .position(fiveLatLng.getAmapLatlng())
                .rotateAngle((float) fiveLatLng.getBearing())
        ));
        fiveMarker.getAmaptMarker().setIcon(BitmapDescriptorFactory.fromResource(imgId));
        return fiveMarker;
    }

    @Override
    public FiveMarker addMarker(FiveLatLng fiveLatLng, String title) {
        return null;
    }

    @Override
    public FiveMarker addMarker(FiveLatLng fiveLatLng, String title, boolean isInfoWindowShow) {
        return null;
    }

    @Override
    public FiveMarker addMarker(FiveLatLng fiveLatLng, String title, int imgID, boolean isInfoWindowShow) {
        return null;
    }

    @Override
    public FiveMarker addMarker(FiveLatLng fiveLatLng, String title, int imgID) {
        return null;
    }

    @Override
    public void addPollyLine(FiveListLatLngContainer fiveListLatLngContainer) {
        if (fiveListLatLngContainer == null || fiveListLatLngContainer.isEmpty()) {
            return;
        }
        List<LatLng> list = fiveListLatLngContainer.getaMaplist();
        addPollyLine(list);
    }

    @Override
    public void addPollyLine(List<LatLng> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        mFiveMap.addPolyline(new PolylineOptions().color(Color.BLUE)
                .addAll(list)
                .useGradient(true)
                .width(16));
    }
}
