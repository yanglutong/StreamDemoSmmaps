package com.example.streamdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellSignalStrengthNr;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.mapapi.search.geocode.GeoCoder;
import com.example.location.AppLication;
import com.example.location.Utils.AlertDialogUtil;
import com.example.location.Utils.GsmInfo;
import com.example.location.Utils.MyToast;
import com.example.streamdemo.nr_lte_cdma_gsm_info.CdmInfo;
import com.example.streamdemo.nr_lte_cdma_gsm_info.LteInfo;
import com.example.streamdemo.nr_lte_cdma_gsm_info.NrInfo;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity  {

    private TextView tv,tv2,tv3,tv5;
    private static ArrayList<String> list = new ArrayList<>();
    private static ArrayList<CdmInfo> cdmInfos;
    private static ArrayList<LteInfo> lteInfos;
    private static ArrayList<GsmInfo> gsmInfos;
    private static ArrayList<NrInfo> nrInfos;
    private GeoCoder mCoder;
    private GeoCoder mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        AlertDialogUtil.newInstance(this).positive(new AlertDialogUtil.OnAlertPositiveListener() {
            @Override
            public void onPositiveClick(int i) {
                MyToast.showToast("确定");
            }
        }).positiveText("确定").negative(new AlertDialogUtil.OnAlertNegativeListener() {
            @Override
            public void onNegativeClick(int i) {
                MyToast.showToast("取消");
            }
        }).negativeText("取消").setCancelable(true).showDialog("是否在本机注册");
        Button viewById = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv5 = findViewById(R.id.tv5);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cdmInfos = new ArrayList<>();//3G集合
                lteInfos = new ArrayList<>();//4G集合
                nrInfos = new ArrayList<>();//5G集合
                gsmInfos = new ArrayList<>();//2G集合
                getGsmInfoList(AppLication.context);
                tv.setText(lteInfos.toString());
                tv2.setText(gsmInfos.toString());
                tv3.setText(cdmInfos.toString());
                tv5.setText(nrInfos.toString());
            }
        });

    }

    public static void getGsmInfoList(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission")
        List<CellInfo> cellInfoList = manager.getAllCellInfo();
        if (cellInfoList != null) {
            for (CellInfo info : cellInfoList) {
                if (info.toString().contains("CellInfoLte")) {
                    CellInfoLte cellInfoLte = (CellInfoLte) info;
                    LteInfo lteInfo=new LteInfo();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        lteInfo.setAdditionalPlmns(cellInfoLte.getCellIdentity().getAdditionalPlmns());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        lteInfo.setBands(cellInfoLte.getCellIdentity().getBands());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        lteInfo.setBandwidth(cellInfoLte.getCellIdentity().getBandwidth());
                    }
                    lteInfo.setCi(cellInfoLte.getCellIdentity().getCi());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        lteInfo.setClosedSubscriberGroupInfo(cellInfoLte.getCellIdentity().getClosedSubscriberGroupInfo());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        lteInfo.setEarfcn(cellInfoLte.getCellIdentity().getEarfcn());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        lteInfo.setMccString(cellInfoLte.getCellIdentity().getMccString());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        lteInfo.setMncString(cellInfoLte.getCellIdentity().getMncString());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        lteInfo.setMobileNetworkOperator(cellInfoLte.getCellIdentity().getMobileNetworkOperator());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        lteInfo.setOperatorAlphaLong(cellInfoLte.getCellIdentity().getOperatorAlphaLong());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        lteInfo.setOperatorAlphaShort(cellInfoLte.getCellIdentity().getOperatorAlphaShort());
                    }
                    lteInfo.setPci(cellInfoLte.getCellIdentity().getPci());
                    lteInfo.setTac(cellInfoLte.getCellIdentity().getTac());
                    lteInfo.setAsuLevel(cellInfoLte.getCellSignalStrength().getAsuLevel());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        lteInfo.setCqi(cellInfoLte.getCellSignalStrength().getCqi());
                    }
                    lteInfo.setDbm(cellInfoLte.getCellSignalStrength().getDbm());
                    lteInfo.setLevel(cellInfoLte.getCellSignalStrength().getLevel());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        lteInfo.setRsrp(cellInfoLte.getCellSignalStrength().getRsrp());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        lteInfo.setRsrq(cellInfoLte.getCellSignalStrength().getRsrq());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        lteInfo.setRssi(cellInfoLte.getCellSignalStrength().getRssi());
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        lteInfo.setRssnr(cellInfoLte.getCellSignalStrength().getRssnr());
                    }
                    lteInfo.setTimingAdvance(cellInfoLte.getCellSignalStrength().getTimingAdvance());
                    lteInfos.add(lteInfo);
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

                    gsmInfos.add(gsmInfo);
                } else if (info.toString().contains("CellInfoCdma")) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) info;
                    CdmInfo cdmInfo = new CdmInfo();
                    cdmInfo.setBasestationId_bid(cellInfoCdma.getCellIdentity().getBasestationId());
                    cdmInfo.setNetworkId_nid(cellInfoCdma.getCellIdentity().getNetworkId());
                    cdmInfo.setSystemId_sid(cellInfoCdma.getCellIdentity().getSystemId());
                    cdmInfo.setAsuLevel(cellInfoCdma.getCellSignalStrength().getAsuLevel());
                    cdmInfo.setCdmaDbm(cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                    cdmInfo.setCdmaEcio(cellInfoCdma.getCellSignalStrength().getCdmaEcio());
                    cdmInfo.setCdmaLevel(cellInfoCdma.getCellSignalStrength().getCdmaLevel());
                    cdmInfo.setDbm(cellInfoCdma.getCellSignalStrength().getDbm());
                    cdmInfo.setEvdoDbm(cellInfoCdma.getCellSignalStrength().getEvdoDbm());
                    cdmInfo.setEvdoEcio(cellInfoCdma.getCellSignalStrength().getEvdoEcio());
                    cdmInfo.setEvdoLevel(cellInfoCdma.getCellSignalStrength().getEvdoLevel());
                    cdmInfo.setEvdoSnr(cellInfoCdma.getCellSignalStrength().getEvdoSnr());
                    cdmInfo.setLevel(cellInfoCdma.getCellSignalStrength().getLevel());
                    cdmInfos.add(cdmInfo);
                }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    if (info instanceof CellInfoNr) {
                        //获取5G数据管理
                        CellIdentityNr nr = (CellIdentityNr) ((CellInfoNr) info).getCellIdentity();
                        CellSignalStrengthNr nrStrength = (CellSignalStrengthNr) ((CellInfoNr) info)
                                .getCellSignalStrength();

                        NrInfo nrInfo =new NrInfo();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            nrInfo.setAdditionalPlmns(nr.getAdditionalPlmns());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            nrInfo.setBands(nr.getBands());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setMccString(nr.getMccString());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setMncString(nr.getMncString());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setNci(nr.getNci());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setNrarfcn(nr.getNrarfcn());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                            nrInfo.setOperatorAlphaLong(nr.getOperatorAlphaLong());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                            nrInfo.setOperatorAlphaShort(nr.getOperatorAlphaShort());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setPci(nr.getPci());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setTac(nr.getTac());
                        }
                        nrInfo.setAsuLevel(nrStrength.getAsuLevel());
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setCsiRsrp(nrStrength.getCsiRsrp());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setCsiRsrq(nrStrength.getCsiRsrq());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setSsSinr(nrStrength.getCsiSinr());
                        }
                        nrInfo.setDbm(nrStrength.getDbm());
                        nrInfo.setLevel(nrStrength.getLevel());
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setSsRsrp(nrStrength.getSsRsrp());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setSsRsrq(nrStrength.getSsRsrq());
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            nrInfo.setSsSinr(nrStrength.getSsSinr());
                        }
                        nrInfos.add(nrInfo);

                    }
                }
            }
        } else {
            Log.e("cellInfoList == null", "");
        }
    }
}