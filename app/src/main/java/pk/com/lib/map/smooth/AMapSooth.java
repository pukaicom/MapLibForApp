package pk.com.lib.map.smooth;

import android.content.Context;
import android.util.Pair;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.amap.api.maps.utils.overlay.SmoothMoveMarker;


import java.util.List;

import pk.com.lib.R;
import pk.com.lib.map.modle.PKLatLng;
import pk.com.lib.map.modle.PKListLatLngContainer;

/**
 * Created by pukai on 16/12/22.
 */
public class AMapSooth extends ISmooth<AMap> {

    private SmoothMoveMarker smoothMoveMarker;
    private PKSmoothListener mPKSmoothListener;
    private int color;
    private int currentIndex;
    private int mTotalDuration;
    private PKListLatLngContainer mPKListLatLngContainer;

    public AMapSooth(AMap aMap, Context context) {
        initMapResource(aMap, context);
    }

    @Override
    public void initSmooth(int color, int totalDuration, PKListLatLngContainer fiveListLatLngContainer, PKSmoothListener fiveSmoothListener) {
        if (fiveListLatLngContainer == null || fiveListLatLngContainer.isEmpty()) {
            return;
        }

        mTotalDuration = totalDuration;
        mPKListLatLngContainer = fiveListLatLngContainer;
        mPKSmoothListener = fiveSmoothListener;
        currentIndex = 0;
        this.color = color;
        final List<LatLng> points = fiveListLatLngContainer.getaMaplist();
        addLine(points);
        smoothMoveMarker = new SmoothMoveMarker(mPKMap);
        smoothMoveMarker.setDescriptor(BitmapDescriptorFactory.fromResource(R.drawable.icon_car));
        LatLng drivePoint = points.get(0);
        final Pair<Integer, LatLng> pair = SpatialRelationUtil.calShortestDistancePoint(points, drivePoint);
        points.set(pair.first, drivePoint);
        List<LatLng> subList = points.subList(pair.first, points.size());
        smoothMoveMarker.setPoints(subList);
        smoothMoveMarker.setTotalDuration(totalDuration);
        smoothMoveMarker.getMarker().hideInfoWindow();
        smoothMoveMarker.setMoveListener(new SmoothMoveMarker.MoveListener() {
            @Override
            public void move(final double distance) {
                if (mPKSmoothListener != null) {
                    LatLng latLng = points.get(currentIndex++);
                    mPKSmoothListener.move(distance, new PKLatLng(latLng.latitude, latLng.longitude), currentIndex);
                    if (distance == 0) {
                        mPKSmoothListener.smoothFinish();
                    }
                }
            }

        });
        mPKMap.addMarker(new MarkerOptions().position(points.get(points.size() - 1)).icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_end)));
        // smoothMoveMarker.startSmoothMove();
    }

    private void addLine(List<LatLng> list) {
        mPKMap.addPolyline(new PolylineOptions().color(color)
                .addAll(list)
                .useGradient(true)
                .width(16));
    }

    @Override
    public void stopSmooth() {
        if (smoothMoveMarker != null) {
            smoothMoveMarker.stopMove();
        }
    }

    @Override
    public void reStartSmooth() {
        if (smoothMoveMarker != null) {
            smoothMoveMarker.destroy();
            mPKMap.clear();
            smoothMoveMarker = null;
        }
        initSmooth(color, mTotalDuration, mPKListLatLngContainer, mPKSmoothListener);
        startSmooth();
    }

    @Override
    public void startSmooth() {
        if (smoothMoveMarker != null) {
            smoothMoveMarker.startSmoothMove();
        }
    }

    @Override
    public void destroySmooth() {
        if (smoothMoveMarker != null) {
            smoothMoveMarker.stopMove();
            smoothMoveMarker.destroy();
            mPKListLatLngContainer = null;
            smoothMoveMarker = null;
        }
    }

    @Override
    public void changSpeed(int totalDuration) {
        smoothMoveMarker.setTotalDuration(totalDuration);
    }
}
