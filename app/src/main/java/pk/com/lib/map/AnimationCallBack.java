package pk.com.lib.map;

/**
 * Created by pukai on 2016-4-26.
 *
 * 公共的地图动画回调接口
 */
public interface AnimationCallBack {
    /**
     * 动画完成后的回调事件
     */
    void animationFinish();

    /**
     * 动画关闭事件
     */
    void onCancel();
}
