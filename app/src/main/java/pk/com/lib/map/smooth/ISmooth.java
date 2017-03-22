package pk.com.lib.map.smooth;


import pk.com.lib.map.MapResource;
import pk.com.lib.map.modle.PKListLatLngContainer;

/**
 * Created by pukai on 16/12/21.
 */
public abstract class ISmooth<T> extends MapResource<T> {
    /**
     * 开始平滑移动
     *
     * @param fiveListLatLngContainer 点集合
     * @param fiveSmoothListener      移动的事件监听
     */
    public abstract void initSmooth(int color, int totalDuration, PKListLatLngContainer fiveListLatLngContainer, PKSmoothListener fiveSmoothListener);

    /**
     * 停止平滑移动
     */
    public abstract void stopSmooth();

    /**
     * 重新开始平滑移动 与@link stopSmooth 相对
     */
    public abstract void reStartSmooth();

    /**
     * 开始平滑移动
     */
    public abstract void startSmooth();

    /**
     * 开始平滑移动
     */
    public abstract void destroySmooth();

    public abstract void changSpeed(int totalDuration);
}
