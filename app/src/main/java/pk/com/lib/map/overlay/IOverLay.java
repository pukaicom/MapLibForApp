package pk.com.lib.map.overlay;

import android.view.View;

import com.amap.api.maps.model.LatLng;


import java.util.List;

import pk.com.lib.map.MapResource;
import pk.com.lib.map.modle.FiveLatLng;
import pk.com.lib.map.modle.FiveListLatLngContainer;
import pk.com.lib.map.modle.FiveMarker;
import pk.com.lib.map.modle.FiveMarkerOptions;

/**
 * Created by pukai on 16/12/21.
 */
public abstract class IOverLay<T> extends MapResource<T> {
    /**
     * 添加标注
     *
     * @param fiveMarkerOptions
     */
    public abstract FiveMarker addMarker(FiveMarkerOptions fiveMarkerOptions);

    /**
     * 添加标注
     *
     * @param fiveLatLng
     * @param view
     */
    public abstract FiveMarker addMarker(FiveLatLng fiveLatLng, View view);

    /**
     * 添加标注
     *
     * @param fiveLatLng
     * @param view
     * @param anchorX    锚点的x
     * @param anchorY    锚点的y
     */
    public abstract FiveMarker addMarker(FiveLatLng fiveLatLng, View view, float anchorX, float anchorY);

    /**
     * 添加标注
     *
     * @param fiveLatLng 经纬度坐标信息
     * @return 经过封装的Fivearker类
     */
    public abstract FiveMarker addMarker(FiveLatLng fiveLatLng, int imgId);

    /**
     * 添加标注
     *
     * @param fiveLatLng 经纬度坐标信息
     * @param title      标题
     * @return 经过封装的Fivearker类
     */
    public abstract FiveMarker addMarker(FiveLatLng fiveLatLng, String title);

    /**
     * 添加标注
     *
     * @param fiveLatLng       经纬度坐标信息
     * @param title            标题
     * @param isInfoWindowShow 标注框是否显示
     * @return 经过封装的Fivearker类
     */
    public abstract FiveMarker addMarker(FiveLatLng fiveLatLng, String title, boolean isInfoWindowShow);

    /**
     * 添加标注
     *
     * @param fiveLatLng       经纬度坐标信息
     * @param title            标题
     * @param isInfoWindowShow 标注框是否显示
     * @return 经过封装的Fivearker类
     */
    public abstract FiveMarker addMarker(FiveLatLng fiveLatLng, String title, int imgID, boolean isInfoWindowShow);

    /**
     * 添加标注使用特定的图标
     *
     * @param fiveLatLng 经纬度坐标信息
     * @param title      标题
     * @return 经过封装的Fivearker类
     */
    public abstract FiveMarker addMarker(FiveLatLng fiveLatLng, String title, int imgID);

    public abstract void addPollyLine(FiveListLatLngContainer fiveListLatLngContainer);

    public abstract void addPollyLine(List<LatLng> latLngs);

}
