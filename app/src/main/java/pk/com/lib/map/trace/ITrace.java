package pk.com.lib.map.trace;


import pk.com.lib.map.MapResource;
import pk.com.lib.map.modle.PKListTraceLocationContainer;

/**
 * Created by pukai on 16/12/21.
 */
public abstract class ITrace<T> extends MapResource<T> {
    /**
     * 开始轨迹纠偏
     * @param fiveListTraceLocationContainer 轨迹的点集合
     * @param fiveTraceListener 轨迹纠偏的回调
     */
    abstract void startTrace(PKListTraceLocationContainer fiveListTraceLocationContainer, PKTraceListener fiveTraceListener);
}
