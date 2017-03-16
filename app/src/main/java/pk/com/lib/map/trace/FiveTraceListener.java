package pk.com.lib.map.trace;


import pk.com.lib.map.modle.FiveListLatLngContainer;

/**
 * Created by pukai on 16/12/26.
 */
public interface FiveTraceListener {
    /**
     * 轨迹纠偏失败的回调
     *
     * @param lineID    路线的id
     * @param errorInfo 错误信息
     */
    void onRequestFailed(int lineID, String errorInfo);

    /**
     * 轨迹纠偏过程中的回调 返回当前已经纠偏过的点和线路id
     *
     * @param lineID                  线路id
     * @param index                   已纠偏的点的数目
     * @param fiveListLatLngContainer 点集合
     */
    void onTraceProcessing(int lineID, int index, FiveListLatLngContainer fiveListLatLngContainer);

    /**
     * 轨迹纠偏完成的回调
     *
     * @param lineID                  线路的id
     * @param fiveListLatLngContainer 纠偏后的所有的点集合
     * @param distance                距离
     * @param waitingTime             等待时间
     */
    void onFinished(int lineID, FiveListLatLngContainer fiveListLatLngContainer, int distance, int waitingTime);
}
