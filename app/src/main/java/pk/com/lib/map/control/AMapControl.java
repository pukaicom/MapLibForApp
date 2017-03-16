package pk.com.lib.map.control;

import android.content.Context;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;

import java.util.List;

import pk.com.lib.map.modle.FiveLatLng;


/**
 * Created by pukai on 16/12/22.
 */
public class AMapControl extends IControl<AMap> {
    public AMapControl(AMap aMap, Context context) {
        initMapResource(aMap, context);
    }

    @Override
    public void setLatLng(List<FiveLatLng> fiveLatLngs) {
        if (fiveLatLngs == null || fiveLatLngs.isEmpty()) {
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (FiveLatLng fiveLatLng : fiveLatLngs) {
            builder.include(fiveLatLng.getAmapLatlng());
        }
        int leftPadding = 100;
        int rightPadding = 100;
        int topPadding = 100;
        int bottomPadding = 251;

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBoundsRect(builder.build(), leftPadding, rightPadding, topPadding, bottomPadding);
        mFiveMap.moveCamera(cameraUpdate);
    }

    @Override
    public void setCenter(FiveLatLng fiveLatLng) {
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(fiveLatLng.getAmapLatlng(), ZOOM, 0, 0));
        mFiveMap.moveCamera(cameraUpdate);
    }
}
