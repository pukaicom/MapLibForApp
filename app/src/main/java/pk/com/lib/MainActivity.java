package pk.com.lib;

import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pk.com.lib.map.MapControl;
import pk.com.lib.map.MapFrament;
import pk.com.lib.map.MapFramentFactory;

public class MainActivity extends AppCompatActivity implements MapControl {


    public final static String FRAGMENT_TAG_MAP = "mapFragment";
    public final static String FRAGMENT_TAG_BUSSINESS = "bussinessFragment";

    MapFrament mapFrament = null;
    BusinessFragment mBusinessFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        mapFrament = (MapFrament) fragmentManager.findFragmentByTag(FRAGMENT_TAG_MAP);
        if (mapFrament == null) {
            mapFrament = MapFramentFactory.createMapFrament(MapFramentFactory.GAODE_MAP_CODE, new Bundle());
            fragmentManager.beginTransaction()
                    .add(R.id.map_container, mapFrament, FRAGMENT_TAG_MAP)
                    .commit();
        }
        new Handler().postAtTime(new Runnable() {
            @Override
            public void run() {
                mBusinessFragment = (BusinessFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG_BUSSINESS);
                if (mBusinessFragment == null) {
                    mBusinessFragment = BusinessFragment.getInstance(getIntent().getExtras());
                    fragmentManager.beginTransaction()
                            .add(R.id.fragment_container, mBusinessFragment, FRAGMENT_TAG_BUSSINESS)
                            .commit();
                }
            }
        }, 200);
    }

    @Override
    public CommonMapFunction getMapController() {
        return mapFrament;
    }
}
