package pk.com.lib.map.overlay;

import android.view.View;

import com.amap.api.maps.model.LatLng;


import java.util.List;

import pk.com.lib.map.MapResource;
import pk.com.lib.map.modle.PKLatLng;
import pk.com.lib.map.modle.PKListLatLngContainer;
import pk.com.lib.map.modle.PKMarker;
import pk.com.lib.map.modle.PKMarkerOptions;

/**
 * Created by pukai on 16/12/21.
 */
public abstract class IOverLay<T> extends MapResource<T> {
    /**
     * 添加标注
     *
     * @param fiveMarkerOptions
     */
    public abstract PKMarker addMarker(PKMarkerOptions fiveMarkerOptions);

    /**
     * 添加标注
     *
     * @param fiveLatLng
     * @param view
     */
    public abstract PKMarker addMarker(PKLatLng fiveLatLng, View view);

    /**
     * 添加标注
     *
     * @param fiveLatLng
     * @param view
     * @param anchorX    锚点的x
     * @param anchorY    锚点的y
     */
    public abstract PKMarker addMarker(PKLatLng fiveLatLng, View view, float anchorX, float anchorY);

    /**
     * 添加标注
     *
     * @param fiveLatLng 经纬度坐标信息
     * @return 经过封装的PKarker类
     */
    public abstract PKMarker addMarker(PKLatLng fiveLatLng, int imgId);

    /**
     * 添加标注
     *
     * @param fiveLatLng 经纬度坐标信息
     * @param title      标题
     * @return 经过封装的PKarker类
     */
    public abstract PKMarker addMarker(PKLatLng fiveLatLng, String title);

    /**
     * 添加标注
     *
     * @param fiveLatLng       经纬度坐标信息
     * @param title            标题
     * @param isInfoWindowShow 标注框是否显示
     * @return 经过封装的PKarker类
     */
    public abstract PKMarker addMarker(PKLatLng fiveLatLng, String title, boolean isInfoWindowShow);

    /**
     * 添加标注
     *
     * @param fiveLatLng       经纬度坐标信息
     * @param title            标题
     * @param isInfoWindowShow 标注框是否显示
     * @return 经过封装的PKarker类
     */
    public abstract PKMarker addMarker(PKLatLng fiveLatLng, String title, int imgID, boolean isInfoWindowShow);

    /**
     * 添加标注使用特定的图标
     *
     * @param fiveLatLng 经纬度坐标信息
     * @param title      标题
     * @return 经过封装的PKarker类
     */
    public abstract PKMarker addMarker(PKLatLng fiveLatLng, String title, int imgID);

    public abstract void addPollyLine(PKListLatLngContainer fiveListLatLngContainer);

    public abstract void addPollyLine(List<LatLng> latLngs);

}
