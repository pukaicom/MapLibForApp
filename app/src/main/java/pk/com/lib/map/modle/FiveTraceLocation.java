package pk.com.lib.map.modle;

import android.os.Parcel;
import android.os.Parcelable;

import com.amap.api.trace.TraceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pukai on 16/12/26.
 */
public class FiveTraceLocation implements Parcelable {
    /**
     * {"deviceId":"015839054985",
     * "receiveTime":1473327304000,
     * "speed":0.0,
     * "longitude":121.3417520174,
     * "latitude":31.175009193,
     * "direction":349,
     * "carStatus":0,
     * "acc":1}
     **/
    private String deviceId;

    private long receiveTime;

    private float speed;

    private double longitude;

    private double latitude;

    private int direction;

    private int carStatus;

    private int acc;

    private TraceLocation aMapTraceLocation;

    public TraceLocation getAmapTraceLocation() {
        if (aMapTraceLocation == null) {
            aMapTraceLocation = new TraceLocation();
            aMapTraceLocation.setSpeed(speed);
            aMapTraceLocation.setLatitude(latitude);
            aMapTraceLocation.setLongitude(latitude);
            aMapTraceLocation.setTime(receiveTime);
            aMapTraceLocation.setBearing(direction);
        }
        return aMapTraceLocation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.deviceId);
        dest.writeLong(this.receiveTime);
        dest.writeFloat(this.speed);
        dest.writeDouble(this.longitude);
        dest.writeDouble(this.latitude);
        dest.writeInt(this.direction);
        dest.writeInt(this.carStatus);
        dest.writeInt(this.acc);
    }

    public FiveTraceLocation() {
    }

    public FiveTraceLocation(TraceLocation traceLocation) {
        if (traceLocation != null) {
            receiveTime = traceLocation.getTime();
            speed = traceLocation.getSpeed();
            longitude = traceLocation.getLongitude();
            latitude = traceLocation.getLatitude();
            direction = (int) traceLocation.getBearing();
        }
    }

    protected FiveTraceLocation(Parcel in) {
        this.deviceId = in.readString();
        this.receiveTime = in.readLong();
        this.speed = in.readFloat();
        this.longitude = in.readDouble();
        this.latitude = in.readDouble();
        this.direction = in.readInt();
        this.carStatus = in.readInt();
        this.acc = in.readInt();
    }

    public static final Creator<FiveTraceLocation> CREATOR = new Creator<FiveTraceLocation>() {
        @Override
        public FiveTraceLocation createFromParcel(Parcel source) {
            return new FiveTraceLocation(source);
        }

        @Override
        public FiveTraceLocation[] newArray(int size) {
            return new FiveTraceLocation[size];
        }
    };

    public static List<TraceLocation> listFiveTraceLocation2AmapTraceLocation(List<FiveTraceLocation> fiveTraceLocationList) {
        List<TraceLocation> amapTraceLation = new ArrayList<>();
        if (fiveTraceLocationList == null || fiveTraceLocationList.isEmpty()) {
        } else {
            for (FiveTraceLocation FiveTraceLocation : fiveTraceLocationList) {
                amapTraceLation.add(FiveTraceLocation.getAmapTraceLocation());
            }
        }
        return amapTraceLation;
    }

    public static List<FiveTraceLocation> listAmapTraceLocation2FiveTraceLocation(List<TraceLocation> aMapTracelocation) {
        List<FiveTraceLocation> fiveTraceLation = new ArrayList<>();
        if (aMapTracelocation == null || aMapTracelocation.isEmpty()) {
        } else {
            for (TraceLocation amapTraceLocation : aMapTracelocation) {
                fiveTraceLation.add(new FiveTraceLocation(amapTraceLocation));
            }
        }
        return fiveTraceLation;
    }
}
