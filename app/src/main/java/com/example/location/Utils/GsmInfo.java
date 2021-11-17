package com.example.location.Utils;

import java.util.Set;

/**
 * @author: 小杨同志
 * @date: 2021/11/2
 */
public class GsmInfo {
    private Set<String> additionalPlmns;
    private int arfcn;
    private int bsic;
    private int cid;
    private int lac;
    private String mccString;
    private String mncString;
    private String mobileNetworkOperator;
    private CharSequence operatorAlphaLong;
    private CharSequence operatorAlphaShort;
    private int psc;
    private int asuLevel;
    private int bitErrorRate;
    private int dbm;
    private int rssi;
    private int timingAdvance;

    @Override
    public String toString() {
        return "GsmInfo{" +
                "additionalPlmns=" + additionalPlmns +
                ", arfcn=" + arfcn +
                ", bsic=" + bsic +
                ", cid=" + cid +
                ", lac=" + lac +
                ", mccString='" + mccString + '\'' +
                ", mncString='" + mncString + '\'' +
                ", mobileNetworkOperator='" + mobileNetworkOperator + '\'' +
                ", operatorAlphaLong=" + operatorAlphaLong +
                ", operatorAlphaShort=" + operatorAlphaShort +
                ", psc=" + psc +
                ", asuLevel=" + asuLevel +
                ", bitErrorRate=" + bitErrorRate +
                ", dbm=" + dbm +
                ", rssi=" + rssi +
                ", timingAdvance=" + timingAdvance +
                '}'+"\r\n\r\n";
    }

    public Set<String> getAdditionalPlmns() {
        return additionalPlmns;
    }

    public void setAdditionalPlmns(Set<String> additionalPlmns) {
        this.additionalPlmns = additionalPlmns;
    }

    public int getArfcn() {
        return arfcn;
    }

    public void setArfcn(int arfcn) {
        this.arfcn = arfcn;
    }

    public int getBsic() {
        return bsic;
    }

    public void setBsic(int bsic) {
        this.bsic = bsic;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getLac() {
        return lac;
    }

    public void setLac(int lac) {
        this.lac = lac;
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

    public int getPsc() {
        return psc;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }

    public int getAsuLevel() {
        return asuLevel;
    }

    public void setAsuLevel(int asuLevel) {
        this.asuLevel = asuLevel;
    }

    public int getBitErrorRate() {
        return bitErrorRate;
    }

    public void setBitErrorRate(int bitErrorRate) {
        this.bitErrorRate = bitErrorRate;
    }

    public int getDbm() {
        return dbm;
    }

    public void setDbm(int dbm) {
        this.dbm = dbm;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getTimingAdvance() {
        return timingAdvance;
    }

    public void setTimingAdvance(int timingAdvance) {
        this.timingAdvance = timingAdvance;
    }
}
