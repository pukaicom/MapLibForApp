package pk.com.lib.map.control;

import java.util.List;

import pk.com.lib.map.MapResource;
import pk.com.lib.map.modle.FiveLatLng;

/**
 * <p>地图的基础控制</p>
 * <ul>缩放</ul>
 * <ul>平移</ul>
 * <ul>变换中心点</ul>
 * Created by pukai on 16/12/21.
 */
public abstract class IControl<T> extends MapResource<T> {
    public abstract void setLatLng(List<FiveLatLng> fiveLatLngs);
    public abstract void setCenter(FiveLatLng fiveLatLng);
}