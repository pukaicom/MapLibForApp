package pk.com.lib;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import pk.com.lib.map.MapControl;
import pk.com.lib.map.modle.FiveLatLng;


/**
 * Created by pukai on 17/3/16.
 */
public class BusinessFragment extends Fragment implements View.OnClickListener {
    private static BusinessFragment mBusinessFragment;
    private MapControl mMapControl;

    //button
    private Button mAddMarkerBtn;
    private Button mDrawLineBtn;
    private Button mMoveMapBtn;
    private Button mDrawRoutBtn;
    private Button mNaviBtn;
    private Button mSmoothBtn;
    private Button mClearMapBtn;
    private Button mQuitBtn;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MapControl) {
            mMapControl = (MapControl) context;
        }
    }

    private BusinessFragment() {
    }

    public static BusinessFragment getInstance(Bundle bundle) {
        if (mBusinessFragment == null) {
            mBusinessFragment = new BusinessFragment();
            mBusinessFragment.setArguments(bundle);
        }
        return mBusinessFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_business, container, false);
        initView(view);
        setOnClickListener();
        return view;
    }

    private void initView(View view) {
        mAddMarkerBtn = (Button) view.findViewById(R.id.fragment_business_add_marker_btn);
        mDrawLineBtn = (Button) view.findViewById(R.id.fragment_business_draw_line_btn);
        mMoveMapBtn = (Button) view.findViewById(R.id.fragment_business_move_map_btn);
        mDrawRoutBtn = (Button) view.findViewById(R.id.fragment_business_draw_rout_btn);
        mNaviBtn = (Button) view.findViewById(R.id.fragment_business_navi_btn);
        mSmoothBtn = (Button) view.findViewById(R.id.fragment_business_smooth_move_btn);
        mClearMapBtn = (Button) view.findViewById(R.id.fragment_business_clear_btn);
        mQuitBtn = (Button) view.findViewById(R.id.fragment_business_cancle_btn);
    }

    private void setOnClickListener() {
        mAddMarkerBtn.setOnClickListener(this);
        mDrawLineBtn.setOnClickListener(this);
        mMoveMapBtn.setOnClickListener(this);
        mDrawRoutBtn.setOnClickListener(this);
        mNaviBtn.setOnClickListener(this);
        mSmoothBtn.setOnClickListener(this);
        mClearMapBtn.setOnClickListener(this);
        mQuitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_business_add_marker_btn:
                mMapControl.getMapController().addBusinessMarker(new FiveLatLng(31.2393627086, 121.4995369338), "东方明珠塔");
                break;
            case R.id.fragment_business_draw_line_btn:
                mMapControl.getMapController().addPollyLine(getTestData());
                break;
            case R.id.fragment_business_move_map_btn:
                List<FiveLatLng> fiveLatLngList = new ArrayList<>();
                fiveLatLngList.add(new FiveLatLng(31.2363627086, 121.4995369338));
                fiveLatLngList.add(new FiveLatLng(31.2423627086, 121.4995369338));
                mMapControl.getMapController().moveMap(fiveLatLngList);
                break;
            case R.id.fragment_business_draw_rout_btn:
                break;
            case R.id.fragment_business_navi_btn:
                break;
            case R.id.fragment_business_smooth_move_btn:
                break;
            case R.id.fragment_business_clear_btn:
                break;
            case R.id.fragment_business_cancle_btn:
                break;

        }
    }

    private List<FiveLatLng> getTestData() {
        List<FiveLatLng> fiveLatLngList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            FiveLatLng fiveLatLng = new FiveLatLng(31.2393627086 - i * 0.01, 121.4995369338 - i * 0.01);
            fiveLatLngList.add(fiveLatLng);
        }
        return fiveLatLngList;
    }
}
