package pk.com.lib.map.modle;

import com.amap.api.trace.TraceLocation;

import java.util.List;

/**
 *  <p>防止各种地图类的List<TraceLocation> 在接口回调时，多次转换成List<PKTraceLocation> 节约时间和空间效率</p>
 * Created by pukai on 16/12/26.
 */
public class PKListTraceLocationContainer {
    private List<TraceLocation> aMaplist;

    private List<PKTraceLocation> fiveTraceLocations;

    public List<TraceLocation> getaMaplist() {
        if(aMaplist==null||aMaplist.isEmpty()){
            aMaplist = PKTraceLocation.listPKTraceLocation2AmapTraceLocation(fiveTraceLocations);
        }
        return aMaplist;
    }

    public void setaMaplist(List<TraceLocation> aMaplist) {
        this.aMaplist = aMaplist;
    }

    public List<PKTraceLocation> getPKTraceLocations() {
        if(fiveTraceLocations==null||fiveTraceLocations.isEmpty()){
            fiveTraceLocations = PKTraceLocation.listAmapTraceLocation2PKTraceLocation(aMaplist);
        }
        return fiveTraceLocations;
    }

    public void setPKTraceLocations(List<PKTraceLocation> fiveTraceLocations) {
        this.fiveTraceLocations = fiveTraceLocations;
    }

    public PKListTraceLocationContainer(List<TraceLocation> aMaplist, List<PKTraceLocation> fiveTraceLocations) {
        this.aMaplist = aMaplist;
        this.fiveTraceLocations = fiveTraceLocations;
    }

    public PKListTraceLocationContainer(List<PKTraceLocation> fiveTraceLocations) {
        this.fiveTraceLocations = fiveTraceLocations;
    }
}
