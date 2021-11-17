package com.example.streamdemo.nr_lte_cdma_gsm_info;

import java.util.Arrays;
import java.util.Set;

/**
 * @author: 小杨同志
 * @date: 2021/11/5
 */
public class NrInfo {
    private Set<String> additionalPlmns;
    private int[] bands;
    private String mccString;
    private String mncString;
    private long nci;
    private int nrarfcn;
    private CharSequence operatorAlphaLong;
    private CharSequence operatorAlphaShort;
    private int pci;
    private int tac;
    private int asuLevel;
    private int csiRsrp;
    private int csiRsrq;
    private int csiSinr;
    private int dbm;
    private int level;
    private int ssRsrp;
    private int ssRsrq;
    private int ssSinr;

    @Override
    public String toString() {
        return "NrInfo{" +
                "additionalPlmns=" + additionalPlmns +
                ", bands=" + Arrays.toString(bands) +
                ", mccString='" + mccString + '\'' +
                ", mncString='" + mncString + '\'' +
                ", nci=" + nci +
                ", nrarfcn=" + nrarfcn +
                ", operatorAlphaLong=" + operatorAlphaLong +
                ", operatorAlphaShort=" + operatorAlphaShort +
                ", pci=" + pci +
                ", tac=" + tac +
                ", asuLevel=" + asuLevel +
                ", csiRsrp=" + csiRsrp +
                ", csiRsrq=" + csiRsrq +
                ", csiSinr=" + csiSinr +
                ", dbm=" + dbm +
                ", level=" + level +
                ", ssRsrp=" + ssRsrp +
                ", ssRsrq=" + ssRsrq +
                ", ssSinr=" + ssSinr +
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

    public long getNci() {
        return nci;
    }

    public void setNci(long nci) {
        this.nci = nci;
    }

    public int getNrarfcn() {
        return nrarfcn;
    }

    public void setNrarfcn(int nrarfcn) {
        this.nrarfcn = nrarfcn;
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

    public int getCsiRsrp() {
        return csiRsrp;
    }

    public void setCsiRsrp(int csiRsrp) {
        this.csiRsrp = csiRsrp;
    }

    public int getCsiRsrq() {
        return csiRsrq;
    }

    public void setCsiRsrq(int csiRsrq) {
        this.csiRsrq = csiRsrq;
    }

    public int getCsiSinr() {
        return csiSinr;
    }

    public void setCsiSinr(int csiSinr) {
        this.csiSinr = csiSinr;
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

    public int getSsRsrp() {
        return ssRsrp;
    }

    public void setSsRsrp(int ssRsrp) {
        this.ssRsrp = ssRsrp;
    }

    public int getSsRsrq() {
        return ssRsrq;
    }

    public void setSsRsrq(int ssRsrq) {
        this.ssRsrq = ssRsrq;
    }

    public int getSsSinr() {
        return ssSinr;
    }

    public void setSsSinr(int ssSinr) {
        this.ssSinr = ssSinr;
    }
}
