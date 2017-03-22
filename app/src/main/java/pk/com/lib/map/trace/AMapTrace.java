package pk.com.lib.map.trace;

import android.content.Context;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;

import java.util.List;

import pk.com.lib.map.modle.PKListLatLngContainer;
import pk.com.lib.map.modle.PKListTraceLocationContainer;

/**<p>高德地图轨迹纠偏的具体实现</p>
 * Created by pukai on 16/12/22.
 */
public class AMapTrace extends ITrace<AMap>{

    //private TraceOverlay mTraceOverlay;
    private LBSTraceClient mTraceClient;
    private int mSequenceLineID = 1000;
    private int mCoordinateType = LBSTraceClient.TYPE_AMAP;

    private PKTraceListener mPKTraceListener;

    public AMapTrace(AMap aMap, Context context){
        initMapResource(aMap,context);
    }
    @Override
    public void startTrace(PKListTraceLocationContainer fiveListTraceLocationContainer, PKTraceListener fiveTraceListener) {
        mPKTraceListener = fiveTraceListener;
        if(fiveListTraceLocationContainer ==null){
            if(mPKTraceListener!=null){
                mPKTraceListener.onFinished(0,null,0,0);
            }
            return;
        }
        List<TraceLocation> traceLocations = fiveListTraceLocationContainer.getaMaplist();
        if(traceLocations==null||traceLocations.isEmpty()){
            if(mPKTraceListener!=null){
                mPKTraceListener.onFinished(0,null,0,0);
            }
            return;
        }
        if(mTraceClient==null){
            mTraceClient = new LBSTraceClient(mContext);
        }
        mTraceClient.queryProcessedTrace(mSequenceLineID,traceLocations,mCoordinateType,mTraceListener);
    }
    private TraceListener mTraceListener = new TraceListener() {
        @Override
        public void onRequestFailed(int lineID, String errorInfo) {
            if(mPKTraceListener!=null){
                mPKTraceListener.onRequestFailed(lineID,errorInfo);
            }
        }

        @Override
        public void onTraceProcessing(int lineID, int index, List<LatLng> list) {
            if(mPKTraceListener!=null){
                PKListLatLngContainer fiveListLatLngContainer = new PKListLatLngContainer();
                fiveListLatLngContainer.setaMaplist(list);
                mPKTraceListener.onTraceProcessing(lineID,index,fiveListLatLngContainer);
            }
        }

        @Override
        public void onFinished(int lineID, List<LatLng> list, int distance, int waitingTime) {
            if(mPKTraceListener!=null) {
                PKListLatLngContainer fiveListLatLngContainer = new PKListLatLngContainer();
                fiveListLatLngContainer.setaMaplist(list);
                mPKTraceListener.onFinished(lineID,fiveListLatLngContainer,distance,waitingTime);
            }
        }
    };
}
