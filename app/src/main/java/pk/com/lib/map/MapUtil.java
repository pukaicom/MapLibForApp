package pk.com.lib.map;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;


import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.List;

import pk.com.lib.map.modle.PKLatLng;

/**
 * Created by dongfang on 2016/4/28.
 */
public class MapUtil {

    /**
     * 百度地图安装标识
     */
    public static final int MAY_TYPE_BAIDU = 0x1;
    /**
     * 高德地图安装标识
     */
    public static final int MAY_TYPE_GAODE = 0x10;
    /**
     * Google地图安装标识
     */
    public static final int MAY_TYPE_GOOGLE = 0x100;
    /**
     * 腾讯地图内部导航
     */
    public static final int MAY_TYPE_TENCENT = 0x1000;

    private static final String MAP_PACKAGE_NAME_BAIDU = "com.baidu.BaiduMap";
    private static final String MAP_PACKAGE_NAME_GAODE = "com.autonavi.minimap";
    private static final String MAP_PACKAGE_NAME_GOOGLE = "com.google.android.apps.maps";

    private static double a = 6378245.0;
    private static double ee = 0.00669342162296594323;
    private static double pi = 3.14159265358979324;
    private static double x_pi = pi * 3000.0 / 180.0;
    private static DecimalFormat sDecimalFormat = new DecimalFormat("#.000000"); //保留6位

    /**
     * 获取终端上安装的导航软件<br>
     * <p/>
     * 1. 百度导航值 {@link MapUtil#MAY_TYPE_BAIDU}<br>
     * 2. 高德导航值 {@link MapUtil#MAY_TYPE_GAODE}<br>
     * 3. 谷歌导航值 {@link MapUtil#MAY_TYPE_GOOGLE}<br>
     *
     * @param context
     * @return 若没有安装导航软件，返回0 ，反正返回安装导航软件的‘与’值
     */
    public static int getMapInstallType(Context context) {
        int type = 0;
        final PackageManager packageManager = context.getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        String packageName = "";
        for (int i = 0, l = pinfo.size(); i < l; i++) {
            packageName = pinfo.get(i).packageName;
            if (packageName.equalsIgnoreCase(MAP_PACKAGE_NAME_BAIDU)) {
                type |= MAY_TYPE_BAIDU;
            } else if (packageName.equalsIgnoreCase(MAP_PACKAGE_NAME_GAODE)) {
                type |= MAY_TYPE_GAODE;
            } else if (packageName.equalsIgnoreCase(MAP_PACKAGE_NAME_GOOGLE)) {
                type |= MAY_TYPE_GOOGLE;
            }
        }
        return type;
    }

    /**
     * 使用高德地图进行导航
     *
     * @param context
     * @param endLat     结束纬度
     * @param endLng     结束经度
     * @param endAdrress 地址名称
     */
    public static void navi2GaoDe(Context context, double endLat, double endLng, String endAdrress) {
        Intent intent = new Intent("android.intent.action.VIEW",
                Uri.parse("androidamap://navi?sourceApplication=" + endAdrress
                        + "&lat=" + endLat
                        + "&lon=" + endLng
                        + "&dev=0"));

        intent.setPackage("com.autonavi.minimap");
        try {
            context.startActivity(intent); // 启动调用
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用百度地图进行导航
     *
     * @param context
     * @param startLat   开始纬度
     * @param startLng   开始经度
     * @param endLat     结束纬度
     * @param endLng     结束经度
     * @param endAdrress 地址名称
     */
    public static void navi2BaiDu(Context context,
                                  double startLat, double startLng,
                                  double endLat, double endLng, String endAdrress) {
        try {
            Intent intent = Intent.parseUri("intent://map/direction?"
                            + "coord_type=gcj02" // 表示使用火星坐标系统
                            + "&origin=|latlng:" + startLat + "," + startLng
                            + "&destination=" + endAdrress
                            + "|latlng:" + endLat + "," + endLng
                            + "&mode=driving&src=" + context.getPackageName()
                            + "|" + "RentPK" // 故意这么写的// + context.getString(R.string.app_name)
                            + "#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end"
                    , 0);

            context.startActivity(intent);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用谷歌地图进行导航
     *
     * @param context
     * @param startLat 开始纬度
     * @param startLng 开始经度
     * @param endLat   结束纬度
     * @param endLng   结束经度
     */
    public static void navi2Google(Context context,
                                   double startLat, double startLng,
                                   double endLat, double endLng) {
        Uri uri = Uri.parse(
                "http://maps.google.com/maps?"
                        + "saddr=" + startLat + "," + startLng
                        + "&"
                        + "daddr=" + endLat + "," + endLng
        );
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        // If you want to get rid of the dialog,Before the startActivity() add this
        intent.setClassName(MAP_PACKAGE_NAME_GOOGLE, "com.google.android.maps.MapsActivity");
        context.startActivity(intent);
    }

    public static PKLatLng transGoogle2Amap(double lat, double lng) {
        return transform2Mars(lat, lng);
    }

    /**
     * 地球坐标转换火星坐标
     *
     * @param wgLat 地球纬度
     * @param wgLon 地球经度
     * @return
     */
    private static PKLatLng transform2Mars(double wgLat, double wgLon) {
        double dLat = transform2MarsLat(wgLon - 105.0, wgLat - 35.0);
        double dLon = transform2MarsLng(wgLon - 105.0, wgLat - 35.0);
        double radLat = wgLat / 180.0 * pi;
        double magic = Math.abs(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double mgLat = wgLat + dLat;
        double mgLon = wgLon + dLon;
        return new PKLatLng(Double.valueOf(sDecimalFormat.format(mgLat)), Double.valueOf(sDecimalFormat.format(mgLon)));
    }

    /**
     * 火星坐标转换百度坐标
     *
     * @param gcLat 地球纬度
     * @param gcLng 地球经度
     * @return
     */
    public static PKLatLng transform2BaiDu(double gcLat, double gcLng) {
        double x = gcLng, y = gcLat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        double bdLat = z * Math.sin(theta) + 0.006;
        double bdLng = z * Math.cos(theta) + 0.0065;
        return new PKLatLng(bdLat, bdLng);
    }

    /**
     * 地球坐标转换火星坐标
     *
     * @param wglat 地球纬度
     * @param wglng 地球经度
     * @return 纬度
     */
    private static double transform2MarsLat(double wglat, double wglng) {
        double ret = -100.0 + 2.0 * wglat + 3.0 * wglng + 0.2 * wglng * wglng + 0.1 * wglat * wglng + 0.2 * Math.sqrt(Math.abs(wglat));
        ret += (20.0 * Math.sin(6.0 * wglat * pi) + 20.0 * Math.sin(2.0 * wglat * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(wglng * pi) + 40.0 * Math.sin(wglng / 3.0 * pi)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(wglng / 12.0 * pi) + 320 * Math.sin(wglng * pi / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    /**
     * 地球坐标转换火星坐标
     *
     * @param wglat 地球纬度
     * @param wglng 地球经度
     * @return 经度
     */
    private static double transform2MarsLng(double wglat, double wglng) {
        double ret = 300.0 + wglat + 2.0 * wglng + 0.1 * wglat * wglat + 0.1 * wglat * wglng + 0.1 * Math.sqrt(Math.abs(wglat));
        ret += (20.0 * Math.sin(6.0 * wglat * pi) + 20.0 * Math.sin(2.0 * wglat * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(wglat * pi) + 40.0 * Math.sin(wglat / 3.0 * pi)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(wglat / 12.0 * pi) + 300.0 * Math.sin(wglat / 30.0 * pi)) * 2.0 / 3.0;
        return ret;
    }


    /**
     * 火星坐标转百度坐标
     *
     * @param gcLat 火星坐标纬度
     * @param gcLng 火星坐标经度
     * @return 百度坐标经度
     */
    private static double transform2BaiDuLng(double gcLat, double gcLng) {
        double x = gcLng, y = gcLat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        return z * Math.cos(theta) + 0.0065;
    }

    /**
     * 火星坐标转百度坐标
     *
     * @param gcLat 火星坐标纬度
     * @param gcLng 火星坐标经度
     * @return 百度坐标纬度
     */
    private static double transform2BaiDuLat(double gcLat, double gcLng) {
        double x = gcLng, y = gcLat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        return z * Math.sin(theta) + 0.006;
    }

    public static boolean isTheSamePlace(PKLatLng fiveLatLng1, PKLatLng fiveLatLng2) {
        //// TODO: 17/2/14 判断两个点是否为同一个点
        return  (Math.abs(fiveLatLng1.getLatitude() - fiveLatLng2.getLatitude()) < 0.0001 && Math.abs(fiveLatLng1.getLongitude() - fiveLatLng2.getLongitude()) < 0.0001);
    }

    public static boolean isTheSameLatlng(PKLatLng fiveLatLng1, PKLatLng fiveLatLng2) {
        // 17/2/14 判断两个点经纬度的误差
        return (Math.abs(fiveLatLng1.getLatitude() - fiveLatLng2.getLatitude()) < 0.0000001 && Math.abs(fiveLatLng1.getLongitude() - fiveLatLng2.getLongitude()) < 0.0000001);
    }
}
