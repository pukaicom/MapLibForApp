package pk.com.lib.map;

import android.content.Context;

import pk.com.lib.map.control.IControl;
import pk.com.lib.map.navi.INavi;
import pk.com.lib.map.overlay.IOverLay;
import pk.com.lib.map.smooth.ISmooth;
import pk.com.lib.map.trace.ITrace;


/**
 * Created by pukai on 16/12/21.
 */
public abstract class MapHelper<T> {
    private T mFiveMap;
    private Context mContext;
    public INavi mINavi;
    public ITrace mITrace;
    public IControl mIControl;
    public ISmooth mISoomth;
    public IOverLay mIOverLay;

    public MapHelper(T fiveMap, Context context) {
        mFiveMap = fiveMap;
        mContext = context;
        mINavi = createNaive(mFiveMap, mContext);
        mITrace = createTrace(mFiveMap, mContext);
        mIControl = createControl(mFiveMap, mContext);
        mISoomth = createSmooth(mFiveMap, mContext);
        mIOverLay = createOverLay(mFiveMap, mContext);
    }

    protected abstract INavi createNaive(T fiveMap, Context context);

    protected abstract ITrace createTrace(T fiveMap, Context context);

    protected abstract IControl createControl(T fiveMap, Context context);

    protected abstract ISmooth createSmooth(T fiveMap, Context context);

    protected abstract IOverLay createOverLay(T fiveMap, Context context);


    public void destrory() {
        mFiveMap = null;
        mContext = null;
        if (mINavi != null) {
            mINavi.destroy();
            mINavi = null;
        }
        if (mITrace != null) {
            mITrace.destroy();
            mITrace = null;
        }
        if (mIControl != null) {
            mIControl.destroy();
            mIControl = null;
        }
        if (mIOverLay != null) {
            mIOverLay.destroy();
            mIOverLay = null;
        }
        if (mISoomth != null) {
            mISoomth.destroy();
            mISoomth = null;
        }
    }

    public MapHelper(INavi mINavi, ITrace mITrace, IControl mIControl, ISmooth mISoomth, IOverLay mIOverLay) {
        this.mINavi = mINavi;
        this.mITrace = mITrace;
        this.mIControl = mIControl;
        this.mISoomth = mISoomth;
        this.mIOverLay = mIOverLay;
    }

    public IOverLay getmIOverLay() {
        return mIOverLay;
    }

    public void setmIOverLay(IOverLay mIOverLay) {
        this.mIOverLay = mIOverLay;
    }

    public INavi getmINavi() {
        return mINavi;
    }

    public void setmINavi(INavi mINavi) {
        this.mINavi = mINavi;
    }

    public ITrace getmITrace() {
        return mITrace;
    }

    public void setmITrace(ITrace mITrace) {
        this.mITrace = mITrace;
    }

    public IControl getmIControl() {
        return mIControl;
    }

    public void setmIControl(IControl mIControl) {
        this.mIControl = mIControl;
    }

    public ISmooth getmISoomth() {
        return mISoomth;
    }

    public void setmISoomth(ISmooth mISoomth) {
        this.mISoomth = mISoomth;
    }

}
