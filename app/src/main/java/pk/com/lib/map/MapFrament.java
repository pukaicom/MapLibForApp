package pk.com.lib.map;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pk.com.lib.CommonMapFunction;
import pk.com.lib.map.smooth.FiveSmoothListener;


/**
 * Created by pukai on 2016-4-26.
 * <p/>
 * 基础地图Fragment
 */
public abstract class MapFrament<T> extends Fragment implements CommonMapFunction {
    /**
     * 当前地图的状态
     */
    protected static final int REAL_LOCATION = 0;
    protected static final int EQUIPMENT_DETAIL = 1;
    protected static final int TRACE_PLAYBACK = 2;

    /**
     * 当前的模式
     * <li>10 车辆</li>
     * <li>11 用户</li>
     * <li>12 自由模式</li>
     */
    public static final int CAR_STYLE = 10;
    public static final int USER_STYLE = 11;
    public static final int FREEDOM_STYLE = 12;

    protected int currentMapStatus;

    protected OnMapClickCallback onMapClickCallback = null;
    protected OnMapLoaded onMapLoadedListener = null;
    protected OnMarkerOnclickListener mOnMarkerOnclickListener;
    protected OnFiveMapTouch mOnFiveMapTouch;
    protected FiveSmoothListener mFiveSmoothListener;
    /**
     * 当前的地图的显示模式
     * <li>10 车辆</li>
     * <li>11 个人</li>
     * <li>12 自由</li>
     */
    protected int currentPositionType;


    public static int ZOOM = 16;
    public static final float SKEW = 0.0f;
    public static final int ROTATE = 0;

    protected final static int TIME_INTERVAL = 1;
    protected final static int TIME_PER_INTERVAL = 5;

    protected int PADDING_MAP;

    protected MapHelper mapHelper;


    public View onCreateView(LayoutInflater layoutinflater,
                             ViewGroup viewgroup, Bundle bundle) {
        currentMapStatus = REAL_LOCATION;
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void registOnMapClickCallback(OnMapClickCallback clickCallback) {
        this.onMapClickCallback = clickCallback;
    }

    protected abstract MapHelper createMapHelper(T fiveMap, Context context);

    public abstract void addMyLocationMarker();

    public void setOnMarkerOnclickListener(OnMarkerOnclickListener listener) {
        mOnMarkerOnclickListener = listener;
    }

    protected MapCenterChangeListener mMapCenterChangeListener;

    public void setMapCenterChangeListener(MapCenterChangeListener mapCenterChangeListener) {
        this.mMapCenterChangeListener = mapCenterChangeListener;
    }

    public void setOnFiveMapTouchListener(OnFiveMapTouch fiveMapTouchListener) {
        this.mOnFiveMapTouch = fiveMapTouchListener;
    }

    public void setSmoothListener(FiveSmoothListener fiveSmoothListener) {
        mFiveSmoothListener = fiveSmoothListener;
    }
}
