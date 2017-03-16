package pk.com.lib.map.modle;

import com.amap.api.maps.model.LatLng;

import java.util.List;

/**
 * <p>f防止各种地图类的List<LatLng> 在接口回调时，多次转换成List<FiveLatLng> 节约时间和空间效率</p>
 * Created by pukai on 16/12/26.
 */
public class FiveListLatLngContainer {
    private List<LatLng> aMaplist;

    private List<FiveLatLng> fiveLatLngs;

    public List<LatLng> getaMaplist() {
        if (aMaplist == null || aMaplist.isEmpty()) {
            aMaplist = FiveLatLng.listFiveLatlng2AmapLatlng(fiveLatLngs);
        }
        return aMaplist;
    }

    public void setaMaplist(List<LatLng> aMaplist) {
        this.aMaplist = aMaplist;
    }

    public List<FiveLatLng> getFiveLatLngs() {
        if (fiveLatLngs == null || fiveLatLngs.isEmpty()) {
            fiveLatLngs = FiveLatLng.listAmapLatlng2FiveLatlng(aMaplist);
        }
        return fiveLatLngs;
    }

    public void setFiveLatLngs(List<FiveLatLng> fiveLatLngs) {
        this.fiveLatLngs = fiveLatLngs;
    }

    public FiveListLatLngContainer(List<LatLng> aMaplist, List<FiveLatLng> fiveLatLngs) {
        this.aMaplist = aMaplist;
        this.fiveLatLngs = fiveLatLngs;
    }

    public FiveListLatLngContainer(List<FiveLatLng> fiveLatLngs) {
        this.fiveLatLngs = fiveLatLngs;
    }

    public FiveListLatLngContainer() {

    }

    public boolean isEmpty() {
        return !((fiveLatLngs != null && !fiveLatLngs.isEmpty()) || (aMaplist != null && !aMaplist.isEmpty()));
    }
}
