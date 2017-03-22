package pk.com.lib.map.modle;

import android.os.Parcel;
import android.os.Parcelable;

import com.amap.api.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pukai on 2016-4-26.
 * 用于接口传递数据的公共经纬度坐标类
 */
public class PKLatLng implements Serializable, Parcelable {
    private static final long serialVersionUID = 1221039181121980934L;
    private double latitude;
    private double longitude;
    private String title;
    private String snippet;

    private double bearing; // 方向, 单位为度, 仅当位置来自GPS时可能有效.
    private int locationType; // 定位数据来源
    private long time; //时间戳 ，long


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public double getBearing() {
        return bearing;
    }

    public void setBearing(double bearing) {
        this.bearing = bearing;
    }

    public int getLocationType() {
        return locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
    }


    public PKLatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PKLatLng(double latitude, double longitude, String ttile, String snippet) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = ttile;
        this.snippet = snippet;
    }

    public boolean hasZeroValue() {
        return latitude == 0.0 || longitude == 0.0;
    }

    public PKLatLng(double latitude, double longitude, double bearing, int locType, long time) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.bearing = bearing;
        this.locationType = locType;
        this.time = time;
    }

    public LatLng getAmapLatlng() {
        return new LatLng(latitude, longitude);
    }

    /**
     * socket坐标上报有用，别修改返回格式
     *
     * @return
     */
    @Override
    public String toString() {
        return latitude + "," + longitude + "," + bearing + "," + locationType + "," + time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeDouble(this.bearing);
        dest.writeLong(this.time);
    }

    protected PKLatLng(Parcel in) {
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.bearing = in.readDouble();
        this.time = in.readLong();
    }

    public static final Creator<PKLatLng> CREATOR = new Creator<PKLatLng>() {
        @Override
        public PKLatLng createFromParcel(Parcel source) {
            return new PKLatLng(source);
        }

        @Override
        public PKLatLng[] newArray(int size) {
            return new PKLatLng[size];
        }
    };

    public static List<LatLng> listPKLatlng2AmapLatlng(List<PKLatLng> list) {
        List<LatLng> amapList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (PKLatLng fiveLatLng : list) {
                amapList.add(fiveLatLng.getAmapLatlng());
            }
        }
        return amapList;
    }

    public static List<PKLatLng> listAmapLatlng2PKLatlng(List<LatLng> list) {
        List<PKLatLng> fiveLatLngs = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (LatLng amapLatlng : list) {
                fiveLatLngs.add(new PKLatLng(amapLatlng.latitude,amapLatlng.longitude));
            }
        }
        return fiveLatLngs;
    }
}
