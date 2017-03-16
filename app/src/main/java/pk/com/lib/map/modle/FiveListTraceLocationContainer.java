package pk.com.lib.map.modle;

import com.amap.api.trace.TraceLocation;

import java.util.List;

/**
 *  <p>防止各种地图类的List<TraceLocation> 在接口回调时，多次转换成List<FiveTraceLocation> 节约时间和空间效率</p>
 * Created by pukai on 16/12/26.
 */
public class FiveListTraceLocationContainer {
    private List<TraceLocation> aMaplist;

    private List<FiveTraceLocation> fiveTraceLocations;

    public List<TraceLocation> getaMaplist() {
        if(aMaplist==null||aMaplist.isEmpty()){
            aMaplist = FiveTraceLocation.listFiveTraceLocation2AmapTraceLocation(fiveTraceLocations);
        }
        return aMaplist;
    }

    public void setaMaplist(List<TraceLocation> aMaplist) {
        this.aMaplist = aMaplist;
    }

    public List<FiveTraceLocation> getFiveTraceLocations() {
        if(fiveTraceLocations==null||fiveTraceLocations.isEmpty()){
            fiveTraceLocations = FiveTraceLocation.listAmapTraceLocation2FiveTraceLocation(aMaplist);
        }
        return fiveTraceLocations;
    }

    public void setFiveTraceLocations(List<FiveTraceLocation> fiveTraceLocations) {
        this.fiveTraceLocations = fiveTraceLocations;
    }

    public FiveListTraceLocationContainer(List<TraceLocation> aMaplist, List<FiveTraceLocation> fiveTraceLocations) {
        this.aMaplist = aMaplist;
        this.fiveTraceLocations = fiveTraceLocations;
    }

    public FiveListTraceLocationContainer(List<FiveTraceLocation> fiveTraceLocations) {
        this.fiveTraceLocations = fiveTraceLocations;
    }
}
