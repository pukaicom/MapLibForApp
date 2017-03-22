package pk.com.lib.map.gaode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Marker;

import java.util.List;

import pk.com.lib.R;
import pk.com.lib.map.MapFrament;
import pk.com.lib.map.MapHelper;
import pk.com.lib.map.modle.PKLatLng;
import pk.com.lib.map.modle.PKListLatLngContainer;
import pk.com.lib.map.modle.PKMarker;

/**
 * Created by pukai on 2016-6-20.
 */
public class AmapFragment extends MapFrament<AMap> implements AMap.OnMapLoadedListener, AMap.OnMarkerClickListener, AMap.OnCameraChangeListener, AMap.OnMapTouchListener {
    private AMap mAMap;
    private MapView mMapView;
    //记录当前添加的marker 再次添加的时候 只需要更改marker的位置 setPotint();
    private PKMarker currentMaker;

    @Override
    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle) {
        View view = layoutinflater.inflate(R.layout.fragment_gaode_map, viewgroup, false);
        mMapView = (MapView) view.findViewById(R.id.amapView);
        mMapView.onCreate(bundle);
        mAMap = mMapView.getMap();

        mAMap.getUiSettings().setLogoPosition(50);
        mAMap.getUiSettings().setZoomControlsEnabled(false);

        mapHelper = createMapHelper(mAMap, getContext());
        mAMap.setOnMarkerClickListener(this);
        mAMap.setOnMapLoadedListener(this);
        mAMap.setOnCameraChangeListener(this);
        mAMap.setOnMapTouchListener(this);
        return view;
    }

    @Override
    protected MapHelper createMapHelper(AMap fiveMap, Context context) {
        return new AMapHelper(fiveMap, context);
    }


    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void addMyLocationMarker() {

    }

    @Override
    public void onMapLoaded() {
        mapHelper.getmIControl().setCenter(new PKLatLng(31.2393627086, 121.4995369338));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    /**
     * marker点击事件的回调 返回true 事件结束 返回false 继续交给底层处理事件
     *
     * @param marker
     * @return
     */
    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    public static MapFrament newInstance(Bundle bundle) {
        AmapFragment amapFragment = new AmapFragment();
        amapFragment.setArguments(bundle);
        return amapFragment;
    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {

    }

    @Override
    public void onCameraChangeFinish(CameraPosition cameraPosition) {

    }

    @Override
    public void onTouch(MotionEvent motionEvent) {

    }

    @Override
    public void setMapCenter(PKLatLng fiveLatLng) {
        mapHelper.getmIControl().setCenter(fiveLatLng);
    }

    @Override
    public void addBusinessMarker(PKLatLng fiveLatLng, String title) {
        if (currentMaker == null) {
            currentMaker = mapHelper.getmIOverLay().addMarker(fiveLatLng, inflatCarStausView(title), 0.1f, 0.5f);
        } else {
            currentMaker.getAmaptMarker().setPosition(fiveLatLng.getAmapLatlng());
        }
    }

    @Override
    public void addPollyLine(List<PKLatLng> fiveLatLngList) {
        mapHelper.getmIOverLay().addPollyLine(new PKListLatLngContainer(fiveLatLngList));
    }

    @Override
    public void moveMap(List<PKLatLng> fiveLatLngList) {
        mapHelper.getmIControl().setLatLng(fiveLatLngList);
    }


    public View inflatCarStausView(String title) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_marker_car, null);
        TextView data = (TextView) view.findViewById(R.id.item_marker_car_data);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_marker_car_image);
        imageView.setImageResource(R.drawable.btn_car_moving_press);
        data.setTextColor(getContext().getResources().getColor(R.color.ct0));
        data.setText(title);
        return view;
    }
}
