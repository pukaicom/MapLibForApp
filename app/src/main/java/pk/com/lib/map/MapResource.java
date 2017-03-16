package pk.com.lib.map;

import android.content.Context;
import android.graphics.Point;

/**
 * Created by pukai on 16/12/22.
 */
public class MapResource<T> {
    /**屏幕的左边界 最小间距 单位px**/
    private final static int LEFT_BORDER = 30;
    /**屏幕的右边界 最小间距 单位px**/
    private final static int RIGHT_BORDER = 30;
    /**屏幕的上边界 最小间距 单位px**/
    private final static int TOP_BORDER = 30;
    /**屏幕的下边界 最小间距 单位px**/
    private final static int BOTTOM_BORDER = 30;
    /** 当前地图的缩放等级**/
    public static float ZOOM = 16;
    /** 当前地图的方向**/
    public static float BEARING = 0;
    /**当前地图的旋转角度**/
    public static float TILT = 0;
    /**屏幕的宽高**/
    private Point screenPoint;

    /** 基础地图资源**/
    protected T mFiveMap;

    protected Context mContext;


    public void initMapResource(T fiveMap, Context context) {
        mFiveMap = fiveMap;
        mContext = context;
    }

    protected void destroy() {
        mFiveMap = null;
        mContext = null;
    }

/*    private boolean isPointInCurrentScreen(LatLng latLng) {
        if (screenPoint == null || screenPoint.equals(0, 0)) {
            screenPoint = DensityUtil.getScrenWidth(mContext);
        }
        Point point = mFiveMap.getAMap().getProjection().toScreenLocation(latLng);
        return point.x < LEFT_BORDER | point.x > screenPoint.x - RIGHT_BORDER || point.y < TOP_BORDER || point.y > screenPoint.y - BOTTOM_BORDER;
    }*/
}
