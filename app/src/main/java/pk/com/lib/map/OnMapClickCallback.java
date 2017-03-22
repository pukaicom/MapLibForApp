package pk.com.lib.map;


import pk.com.lib.map.modle.PKMarker;

/**
 * Created by pukai on 2016-4-27.
 *
 * 地图公共的点击回调接口
 */
public interface OnMapClickCallback {
    /**
     * 地图点击的回调事件
     * @param fiveMarker 返回添加的标注
     */
    void onMapClicked(PKMarker fiveMarker);
}
