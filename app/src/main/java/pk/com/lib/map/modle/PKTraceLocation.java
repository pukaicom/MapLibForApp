package pk.com.lib.map.modle;

import android.os.Parcel;
import android.os.Parcelable;

import com.amap.api.trace.TraceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pukai on 16/12/26.
 */
public class PKTraceLocation implements Parcelable {

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

    public PKTraceLocation() {
    }

    public PKTraceLocation(TraceLocation traceLocation) {
        if (traceLocation != null) {
            receiveTime = traceLocation.getTime();
            speed = traceLocation.getSpeed();
            longitude = traceLocation.getLongitude();
            latitude = traceLocation.getLatitude();
            direction = (int) traceLocation.getBearing();
        }
    }

    protected PKTraceLocation(Parcel in) {
        this.deviceId = in.readString();
        this.receiveTime = in.readLong();
        this.speed = in.readFloat();
        this.longitude = in.readDouble();
        this.latitude = in.readDouble();
        this.direction = in.readInt();
        this.carStatus = in.readInt();
        this.acc = in.readInt();
    }

    public static final Creator<PKTraceLocation> CREATOR = new Creator<PKTraceLocation>() {
        @Override
        public PKTraceLocation createFromParcel(Parcel source) {
            return new PKTraceLocation(source);
        }

        @Override
        public PKTraceLocation[] newArray(int size) {
            return new PKTraceLocation[size];
        }
    };

    public static List<TraceLocation> listPKTraceLocation2AmapTraceLocation(List<PKTraceLocation> fiveTraceLocationList) {
        List<TraceLocation> amapTraceLation = new ArrayList<>();
        if (fiveTraceLocationList == null || fiveTraceLocationList.isEmpty()) {
        } else {
            for (PKTraceLocation PKTraceLocation : fiveTraceLocationList) {
                amapTraceLation.add(PKTraceLocation.getAmapTraceLocation());
            }
        }
        return amapTraceLation;
    }

    public static List<PKTraceLocation> listAmapTraceLocation2PKTraceLocation(List<TraceLocation> aMapTracelocation) {
        List<PKTraceLocation> fiveTraceLation = new ArrayList<>();
        if (aMapTracelocation == null || aMapTracelocation.isEmpty()) {
        } else {
            for (TraceLocation amapTraceLocation : aMapTracelocation) {
                fiveTraceLation.add(new PKTraceLocation(amapTraceLocation));
            }
        }
        return fiveTraceLation;
    }
}
