package pk.com.lib.map.modle;

import com.amap.api.maps.model.Marker;

import java.util.List;

public class EquipmentMarkerHolder {

    public EquipmentMarkerHolder(FiveLatLng fiveLatLng, List<EuipmentInfo> infos) {
        this.fiveLatLng = fiveLatLng;
        this.infos = infos;
    }
    public Marker marker;
    public FiveLatLng fiveLatLng;
    public List<EuipmentInfo> infos;
}

