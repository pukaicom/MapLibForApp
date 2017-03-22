package pk.com.lib.map.modle;

import com.amap.api.maps.model.Marker;

import java.util.List;

public class PKEquipmentMarkerHolder {

    public PKEquipmentMarkerHolder(PKLatLng fiveLatLng, List<PKEuipmentInfo> infos) {
        this.fiveLatLng = fiveLatLng;
        this.infos = infos;
    }
    public Marker marker;
    public PKLatLng fiveLatLng;
    public List<PKEuipmentInfo> infos;
}

