package com.example.streamdemo.nr_lte_cdma_gsm_info;

import android.telephony.ClosedSubscriberGroupInfo;

import java.util.Arrays;
import java.util.Set;

/**
 * @author: 小杨同志
 * @date: 2021/11/5
 */
public class LteInfo {
    private Set<String> additionalPlmns;
    private int[] bands;
    private int bandwidth;
    private int ci;
    private int earfcn;
    private ClosedSubscriberGroupInfo closedSubscriberGroupInfo;
    private String mccString;
    private String mncString;
    private String mobileNetworkOperator;
    private CharSequence operatorAlphaLong;
    private CharSequence operatorAlphaShort;
    private int pci;
    private int tac;
    private int asuLevel;
    private int cqi;
    private int dbm;
    private int level;
    private int rsrp;
    private int rsrq;
    private int rssi;
    private int rssnr;
    private int timingAdvance;

    @Override
    public String toString() {
        return "LteInfo{" +
                "additionalPlmns=" + additionalPlmns +
                ", bands=" + Arrays.toString(bands) +
                ", bandwidth=" + bandwidth +
                ", ci=" + ci +
                ", earfcn=" + earfcn +
                ", closedSubscriberGroupInfo=" + closedSubscriberGroupInfo +
                ", mccString='" + mccString + '\'' +
                ", mncString='" + mncString + '\'' +
                ", mobileNetworkOperator='" + mobileNetworkOperator + '\'' +
                ", operatorAlphaLong=" + operatorAlphaLong +
                ", operatorAlphaShort=" + operatorAlphaShort +
                ", pci=" + pci +
                ", tac=" + tac +
                ", asuLevel=" + asuLevel +
                ", cqi=" + cqi +
                ", dbm=" + dbm +
                ", level=" + level +
                ", rsrp=" + rsrp +
                ", rsrq=" + rsrq +
                ", rssi=" + rssi +
                ", rssnr=" + rssnr +
                ", timingAdvance=" + timingAdvance +
                '}'+"\r\n\r\n";
    }

    public Set<String> getAdditionalPlmns() {
        return additionalPlmns;
    }

    public void setAdditionalPlmns(Set<String> additionalPlmns) {
        this.additionalPlmns = additionalPlmns;
    }

    public int[] getBands() {
        return bands;
    }

    public void setBands(int[] bands) {
        this.bands = bands;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getEarfcn() {
        return earfcn;
    }

    public void setEarfcn(int earfcn) {
        this.earfcn = earfcn;
    }

    public ClosedSubscriberGroupInfo getClosedSubscriberGroupInfo() {
        return closedSubscriberGroupInfo;
    }

    public void setClosedSubscriberGroupInfo(ClosedSubscriberGroupInfo closedSubscriberGroupInfo) {
        this.closedSubscriberGroupInfo = closedSubscriberGroupInfo;
    }

    public String getMccString() {
        return mccString;
    }

    public void setMccString(String mccString) {
        this.mccString = mccString;
    }

    public String getMncString() {
        return mncString;
    }

    public void setMncString(String mncString) {
        this.mncString = mncString;
    }

    public String getMobileNetworkOperator() {
        return mobileNetworkOperator;
    }

    public void setMobileNetworkOperator(String mobileNetworkOperator) {
        this.mobileNetworkOperator = mobileNetworkOperator;
    }

    public CharSequence getOperatorAlphaLong() {
        return operatorAlphaLong;
    }

    public void setOperatorAlphaLong(CharSequence operatorAlphaLong) {
        this.operatorAlphaLong = operatorAlphaLong;
    }

    public CharSequence getOperatorAlphaShort() {
        return operatorAlphaShort;
    }

    public void setOperatorAlphaShort(CharSequence operatorAlphaShort) {
        this.operatorAlphaShort = operatorAlphaShort;
    }

    public int getPci() {
        return pci;
    }

    public void setPci(int pci) {
        this.pci = pci;
    }

    public int getTac() {
        return tac;
    }

    public void setTac(int tac) {
        this.tac = tac;
    }

    public int getAsuLevel() {
        return asuLevel;
    }

    public void setAsuLevel(int asuLevel) {
        this.asuLevel = asuLevel;
    }

    public int getCqi() {
        return cqi;
    }

    public void setCqi(int cqi) {
        this.cqi = cqi;
    }

    public int getDbm() {
        return dbm;
    }

    public void setDbm(int dbm) {
        this.dbm = dbm;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRsrp() {
        return rsrp;
    }

    public void setRsrp(int rsrp) {
        this.rsrp = rsrp;
    }

    public int getRsrq() {
        return rsrq;
    }

    public void setRsrq(int rsrq) {
        this.rsrq = rsrq;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getRssnr() {
        return rssnr;
    }

    public void setRssnr(int rssnr) {
        this.rssnr = rssnr;
    }

    public int getTimingAdvance() {
        return timingAdvance;
    }

    public void setTimingAdvance(int timingAdvance) {
        this.timingAdvance = timingAdvance;
    }
}
