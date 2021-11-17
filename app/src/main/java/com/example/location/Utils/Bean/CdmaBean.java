package com.example.location.Utils.Bean;

/**
 * @author: 小杨同志
 * @date: 2021/11/2
 */
public class CdmaBean {
    private String mcc;
    private String sid_mnc;
    private String nid_lac;
    private String bid_ci;

    @Override
    public String toString() {
        return "CdmaBean{" +
                "mcc='" + mcc + '\'' +
                ", sid_mnc='" + sid_mnc + '\'' +
                ", nid_lac='" + nid_lac + '\'' +
                ", bid_ci='" + bid_ci + '\'' +
                '}';
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getSid_mnc() {
        return sid_mnc;
    }

    public void setSid_mnc(String sid_mnc) {
        this.sid_mnc = sid_mnc;
    }

    public String getNid_lac() {
        return nid_lac;
    }

    public void setNid_lac(String nid_lac) {
        this.nid_lac = nid_lac;
    }

    public String getBid_ci() {
        return bid_ci;
    }

    public void setBid_ci(String bid_ci) {
        this.bid_ci = bid_ci;
    }
}
