package com.example.location.Utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;

import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.example.location.Utils.Bean.CdmaBean;
import com.example.location.Utils.Bean.SpBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by admin on 2020/4/15.
 */

public class DtUtils {
    public static String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.FOREGROUND_SERVICE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.GET_TASKS,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
            Manifest.permission.ACCESS_NOTIFICATION_POLICY,
            Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.REQUEST_INSTALL_PACKAGES,
            Manifest.permission.WAKE_LOCK,
            Manifest.permission.RECEIVE_BOOT_COMPLETED,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.FOREGROUND_SERVICE,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.GET_TASKS,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
            Manifest.permission.ACCESS_NOTIFICATION_POLICY,
            Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.REQUEST_INSTALL_PACKAGES,
            Manifest.permission.WAKE_LOCK,
            Manifest.permission.RECEIVE_BOOT_COMPLETED
    };
    //    Manifest.permission.DEVICE_POWER
    //???????????????
    public static List<String> mPermissionList = new ArrayList<>();
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private static final int MY_PERMISSIONS_REQUEST_CALL_CAMERA = 2;

    @SuppressLint({"NewApi", "LongLogTag"})
    public static List<SpBean> getGsmInfoList(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") List<CellInfo> cellInfoList = manager.getAllCellInfo();
        Log.d("cellInfoListnzq", "getGsmInfoList: " + cellInfoList);
        List<SpBean> gsmInfoList = new ArrayList<>();
        if (cellInfoList != null) {
            Log.e("cellInfoList.size=" + cellInfoList.size(), "");
//            GsmInfo gsmInfo;
            SpBean bean;
            for (CellInfo info : cellInfoList) {
                Log.e("nzqinfos" + info.toString(), "");
                if (info.toString().contains("CellInfoLte")) {
                    CellInfoLte cellInfoLte = (CellInfoLte) info;
                    CellIdentityLte cellIdentityLte = cellInfoLte.getCellIdentity();
//                    NeighboringCellInfo neighboringCellInfo=new   NeighboringCellInfo ();
//                    neighboringCellInfo
                    bean = new SpBean();
//                    cellIdentityLte.
                    String mobileNetworkOperator = cellIdentityLte.getMobileNetworkOperator();
                    Log.d("nzqmobileNetworkOperator", "getGsmInfoList: " + mobileNetworkOperator);
//                    bean.setMcc(cellIdentityLte.getMcc());
                    String TAG = "yltDtUtils";
                    cellIdentityLte.getMncString();
                    Log.e(TAG, "getGsmInfoList: " + cellIdentityLte.getMccString());
                    Log.e(TAG, "getGsmInfoList: " + cellIdentityLte.getMncString());
                    //????????????
                    String mobileNetworkOperator1 = cellIdentityLte.getMobileNetworkOperator();
                    String yy = YY(mobileNetworkOperator1);
                    if (yy.equals("??????")) {
                        bean.setUp("255");
                    }
                    if (yy.equals("??????")) {
                        int i = cellIdentityLte.getEarfcn();
                        int i1 = i + 18000;
                        bean.setUp(i1 + "");
                    }
                    if (yy.equals("??????")) {
                        int i = cellIdentityLte.getEarfcn();
                        int i1 = i + 18000;
                        bean.setUp(i1 + "");

                    }
//                    String.valueOf()
                    bean.setTac(cellIdentityLte.getTac());
                    bean.setCid(cellIdentityLte.getCi());
//                    bean.setRssi(cellInfoLte.getCellSignalStrength().getRssi());
                    bean.setRsrp(cellInfoLte.getCellSignalStrength().getRsrp() + "");
                    bean.setRsrq(cellInfoLte.getCellSignalStrength().getRsrq() + "");
                    bean.setDown(cellIdentityLte.getEarfcn() + "");
                    bean.setPci(cellIdentityLte.getPci() + "");
                    bean.setPlmn(cellIdentityLte.getMobileNetworkOperator());
                    bean.setBand(getBand(cellIdentityLte.getEarfcn()));
                    bean.setMcc(cellIdentityLte.getMccString());
                    bean.setMnc(cellIdentityLte.getMncString());
                    bean.setZw(true);
                    Log.d("beanaa", "getGsmInfoList: ." + bean);
                    gsmInfoList.add(bean);
                } else if (info.toString().contains("CellInfoGsm")) {
//                    CellInfoGsm cellInfoGsm = (CellInfoGsm) info;
//                    CellIdentityGsm cellIdentityGsm = cellInfoGsm.getCellIdentity();
//
//                    GsmInfo gsmInfo = new GsmInfo();
//                    gsmInfo.setMcc(cellIdentityGsm.getMcc());
//                    gsmInfo.setMnc(cellIdentityGsm.getMnc());
//                    gsmInfo.setLac(cellIdentityGsm.getLac());
//                    gsmInfo.setCid(cellIdentityGsm.getCid());
//                    gsmInfo.setEar(cellIdentityGsm.getArfcn());
//                    gsmInfo.setRssi(cellInfoGsm.getCellSignalStrength().getDbm());
//
//                    gsmInfoList.add(gsmInfo);
                } else if (info.toString().contains("CellInfoCdma")) {
                    CellInfoCdma cellInfoGsm = (CellInfoCdma) info;

//                    Log.e("gsmInfoList", "getGsmInfoList: "+gsmCellLocation.getCid());
//                    Log.e("gsmInfoList", "getGsmInfoList: "+gsmCellLocation.getLac());
//                    Log.e("gsmInfoList", "getGsmInfoList: "+gsmCellLocation.getPsc());
//                    CellInfoCdma cellInfoCdma = (CellInfoCdma) info;
//                    CellIdentityCdma cellIdentityCdma = cellInfoCdma.getCellIdentity();
//                    cellInfoCdma.getCellIdentity().get
//                    GsmInfo gsmInfo;
//                    gsmInfo = new GsmInfo();
//                    gsmInfo.setMcc(460);
//                    gsmInfo.setMnc(0);
//                    gsmInfo.setLac(0);
//                    gsmInfo.setCid(cellIdentityCdma.getBasestationId());
//                    gsmInfo.setRssi(cellInfoCdma.getCellSignalStrength().getDbm());
//                    gsmInfo.setRssi(cellInfoCdma.getCellSignalStrength().getCdmaEcio());
//                    gsmInfoList.add(gsmInfo);
                } else if (info.toString().contains("CellInfoNr")) {

                }
            }
        } else {
            Log.e("cellInfoList == null", "");
        }

        return gsmInfoList;
    }

    public static List<CdmaBean> getCdmAList(Context context) {
        ArrayList<CdmaBean> cdmaBeans = new ArrayList<>();
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") List<CellInfo> cellInfoList = manager.getAllCellInfo();
        Log.d("cellInfoListnzq", "getGsmInfoList: " + cellInfoList);
        if (cellInfoList != null) {
            for (CellInfo info : cellInfoList) {
                if (info.toString().contains("CellInfoLte")) {
                } else if (info.toString().contains("CellInfoGsm")) {
                } else if (info.toString().contains("CellInfoCdma")) {
                    CellInfoCdma cdma = (CellInfoCdma) info;
                    CellIdentityCdma gsmCellLocation = cdma.getCellIdentity();
                    Log.i("yltgetCdmAList", "getGsmInfoList: ");
                    int cid = gsmCellLocation.getBasestationId(); //??????cdma?????????????????? BID
                    int lac = gsmCellLocation.getNetworkId(); //??????cdma????????????NID
                    int sid = gsmCellLocation.getSystemId(); //?????????API??????cdma?????????mnc????????????getSystemId()?????????SID
                    CdmaBean cdmaBean;
                    cdmaBean = new CdmaBean();
                    cdmaBean.setMcc("");
                    cdmaBean.setBid_ci(cid + "");
                    cdmaBean.setNid_lac(lac + "");
                    cdmaBean.setSid_mnc(sid + "");
                    cdmaBeans.add(cdmaBean);

//                    GsmInfo gsmInfo;
//                    gsmInfo = new GsmInfo();
//                    gsmInfo.setMcc(460);
//                    gsmInfo.setMnc(0);
//                    gsmInfo.setLac(0);
//                    gsmInfo.setCid(cellIdentityCdma.getBasestationId());
//                    gsmInfo.setRssi(cellInfoCdma.getCellSignalStrength().getDbm());
//                    gsmInfo.setRssi(cellInfoCdma.getCellSignalStrength().getCdmaEcio());
//                    gsmInfoList.add(gsmInfo);
                } else if (info.toString().contains("CellInfoNr")) {
                }
            }
        } else {
            Log.e("cellInfoList == null", "");
        }

        return cdmaBeans;
    }

    public static List<GsmInfo> getGsmList(Context context) {
        ArrayList<GsmInfo> gsms = new ArrayList<>();
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") List<CellInfo> cellInfoList = manager.getAllCellInfo();
        if (cellInfoList != null) {
            for (CellInfo info : cellInfoList) {
                if (info.toString().contains("CellInfoLte")) {
                } else if (info.toString().contains("CellInfoGsm")) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) info;
                    GsmInfo gsmInfo=new GsmInfo();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        gsmInfo.setAdditionalPlmns(cellInfoGsm.getCellIdentity().getAdditionalPlmns());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        gsmInfo.setArfcn(cellInfoGsm.getCellIdentity().getArfcn());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        gsmInfo.setBsic(cellInfoGsm.getCellIdentity().getBsic());
                    }
                    gsmInfo.setCid(cellInfoGsm.getCellIdentity().getCid());
                    gsmInfo.setLac(cellInfoGsm.getCellIdentity().getLac());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        gsmInfo.setMccString(cellInfoGsm.getCellIdentity().getMccString());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        gsmInfo.setMncString(cellInfoGsm.getCellIdentity().getMncString());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        gsmInfo.setMobileNetworkOperator(cellInfoGsm.getCellIdentity().getMobileNetworkOperator());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        gsmInfo.setOperatorAlphaLong(cellInfoGsm.getCellIdentity().getOperatorAlphaLong());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        gsmInfo.setOperatorAlphaShort(cellInfoGsm.getCellIdentity().getOperatorAlphaShort());
                    }
                    gsmInfo.setPsc(cellInfoGsm.getCellIdentity().getPsc());
                    gsmInfo.setAsuLevel(cellInfoGsm.getCellSignalStrength().getAsuLevel());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        gsmInfo.setBitErrorRate(cellInfoGsm.getCellSignalStrength().getBitErrorRate());
                    }
                    gsmInfo.setDbm(cellInfoGsm.getCellSignalStrength().getDbm());
                    gsmInfo.setAsuLevel(cellInfoGsm.getCellSignalStrength().getLevel());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        gsmInfo.setRssi(cellInfoGsm.getCellSignalStrength().getRssi());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        gsmInfo.setTimingAdvance(cellInfoGsm.getCellSignalStrength().getTimingAdvance());
                    }
                    gsms.add(gsmInfo);
                } else if (info.toString().contains("CellInfoCdma")) {

                } else if (info.toString().contains("CellInfoNr")) {
                }
            }
        } else {
            Log.e("cellInfoList == null", "");
        }
        return gsms;
    }
    /**
     * ????????????
     */
    public static void getPermissions(Context context) {//??????????????????
        mPermissionList.clear();
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(context, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(permissions[i]);
            }
        }
        if (mPermissionList.isEmpty()) {//?????????????????????????????????????????????
//            Toast.makeText(LoginActivity.this,"????????????",Toast.LENGTH_LONG).show();
        } else {//??????????????????
            String[] permissions = mPermissionList.toArray(new String[mPermissionList.size()]);//???List????????????
            ActivityCompat.requestPermissions((Activity) context, permissions, MY_PERMISSIONS_REQUEST_CALL_CAMERA);
        }
    }

    /**
     * ????????????IMSI
     */
    public static String getIMSI(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            //??????IMSI???
            @SuppressLint({"HardwareIds", "MissingPermission"}) String imsi = telephonyManager.getSimSerialNumber();
            if (null == imsi) {
                imsi = "";
            }
            return imsi;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * ???????????????????????????
     *
     * @return ???????????????
     */
//    public static String getDeviceId() {
//        // ?????? SharedPreferences ?????? GUID
//        String guid = SPUtils.getInstance().getString(AppConfig.SP_GUID);
//        if (!TextUtils.isEmpty(guid)) {
//            return guid;
//        }
//
//        // ?????? ANDROID_ID
//        String android_id = Settings.System.getString(
//                App.getApp().getContentResolver(), Settings.Secure.ANDROID_ID);
//        if (!TextUtils.isEmpty(android_id)) {
//            // ?????? ANDROID_ID ?????? guid?????????????????????
//            guid = EncryptUtils.encryptMD5ToString(android_id);
//        } else {
//            // ?????? UUID ?????? guid?????????????????????
//            guid = EncryptUtils.encryptMD5ToString(UUID.randomUUID().toString());
//        }
//        // ?????? guid ??? SharedPreferences
//        SPUtils.getInstance().put(AppConfig.SP_GUID, guid);
//        return guid;
//    }
    public static String YY(String imsi) {

        String s = "";
        if (!TextUtils.isEmpty(imsi)){

            if (imsi.startsWith("46000")) {//????????????????????????46000??????IMSI????????????????????????????????????46002?????????134/159????????????????????????
                //????????????
                Log.d("aimsistartsWith", "init: ????????????");
                s = "??????";
                return s;
            } else if (imsi.startsWith("46001")) {
                //????????????
                Log.d("aimsistartsWith", "init: ????????????");
                s = "??????";

            } else if (imsi.startsWith("46003") || (imsi.startsWith("46011"))) {
                //????????????
                Log.d("aimsistartsWith", "init: ????????????");
                s = "??????";
            }

        }

        return s;
    }
    public static int YY2(String imsi) {

        int s = 0;
        if (imsi.startsWith("46000")) {//????????????????????????46000??????IMSI????????????????????????????????????46002?????????134/159????????????????????????
            //????????????
            Log.d("aimsistartsWith", "init: ????????????");
            s = 0;
            return s;
        } else if (imsi.startsWith("46001")) {
            //????????????
            Log.d("aimsistartsWith", "init: ????????????");
            s = 1;
            return s;
        } else if (imsi.startsWith("46003") || (imsi.startsWith("46011"))) {
            //????????????
            Log.d("aimsistartsWith", "init: ????????????");
            s = 11;
            return s;
        }
        return s;
    }
    public static String getBand(int down) {
        String BAND = "1";

        if (down >= 0 && down <= 599) {
            BAND = "1";
            return BAND;
        }

        if (down >= 1200 && down <= 1949) {
            BAND = "3";
            return BAND;
        }

        if (down >= 2400 && down <= 2649) {
            BAND = "5";
            return BAND;
        }


        if (down >= 3450 && down <= 3799) {
            BAND = "8";
            return BAND;
            //FDD
        }

        if (down >= 36200 && down <= 36349) {
            BAND = "34";
            return BAND;
        }
        if (down >= 37750 && down <= 38249) {
            BAND = "38";
            return BAND;
        }
        if (down >= 38250 && down <= 38649) {
            BAND = "39";
            return BAND;
        }
        if (down >= 38650 && down <= 39649) {
            BAND = "40";
            return BAND;
        }
        if (down >= 39650 && down <= 41589) {
            BAND = "41";
            return BAND;
        }
        return BAND;

    }

    /**
     * ??????MAC??????
     *
     * @param context
     * @return
     */
    public static String getMacAddress(Context context) {
        String mac = "02:00:00:00:00:00";
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            mac = getMacDefault(context);
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mac = getMacFromFile();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mac = getMacFromHardware();
        }
        return mac;
    }

    private static String getMacDefault(Context context) {
        String mac = "02:00:00:00:00:00";
        if (context == null) {
            return mac;
        }

        WifiManager wifi = (WifiManager) context.getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        if (wifi == null) {
            return mac;
        }
        WifiInfo info = null;
        try {
            info = wifi.getConnectionInfo();
        } catch (Exception e) {
        }
        if (info == null) {
            return null;
        }
        mac = info.getMacAddress();
        if (!TextUtils.isEmpty(mac)) {
            mac = mac.toUpperCase(Locale.ENGLISH);
        }
        return mac;
    }

    /**
     * Android 6.0???????????? - Android 7.0???????????????
     *
     * @return
     */
    private static String getMacFromFile() {
        String WifiAddress = "02:00:00:00:00:00";
        try {
            WifiAddress = new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return WifiAddress;
    }

    /**
     * ??????????????????????????????????????????????????? wlan0
     * ??????????????? <uses-permission android:name="android.permission.INTERNET" />
     *
     * @return
     */
    private static String getMacFromHardware() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:", b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }


}
