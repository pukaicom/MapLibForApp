package pk.com.lib.map.modle;

import com.amap.api.maps.model.LatLng;

import java.util.List;

/**
 * <p>f防止各种地图类的List<LatLng> 在接口回调时，多次转换成List<PKLatLng> 节约时间和空间效率</p>
 * Created by pukai on 16/12/26.
 */
public class PKListLatLngContainer {
    private List<LatLng> aMaplist;

    private List<PKLatLng> fiveLatLngs;

    public List<LatLng> getaMaplist() {
        if (aMaplist == null || aMaplist.isEmpty()) {
            aMaplist = PKLatLng.listPKLatlng2AmapLatlng(fiveLatLngs);
        }
        return aMaplist;
    }

    public void setaMaplist(List<LatLng> aMaplist) {
        this.aMaplist = aMaplist;
    }

    public List<PKLatLng> getPKLatLngs() {
        if (fiveLatLngs == null || fiveLatLngs.isEmpty()) {
            fiveLatLngs = PKLatLng.listAmapLatlng2PKLatlng(aMaplist);
        }
        return fiveLatLngs;
    }

    public void setPKLatLngs(List<PKLatLng> fiveLatLngs) {
        this.fiveLatLngs = fiveLatLngs;
    }

    public PKListLatLngContainer(List<LatLng> aMaplist, List<PKLatLng> fiveLatLngs) {
        this.aMaplist = aMaplist;
        this.fiveLatLngs = fiveLatLngs;
    }

    public PKListLatLngContainer(List<PKLatLng> fiveLatLngs) {
        this.fiveLatLngs = fiveLatLngs;
    }

    public PKListLatLngContainer() {

    }

    public boolean isEmpty() {
        return !((fiveLatLngs != null && !fiveLatLngs.isEmpty()) || (aMaplist != null && !aMaplist.isEmpty()));
    }
}
