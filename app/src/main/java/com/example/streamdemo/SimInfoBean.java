package com.example.streamdemo;

/**
 * @author: 小杨同志
 * @date: 2021/11/3
 */
public class SimInfoBean {
    private String mcc;
    private String mnc;
    private String sImIndex;

    @Override
    public String toString() {
        return "SimInfoBean{" +
                "mcc='" + mcc + '\'' +
                ", mnc='" + mnc + '\'' +
                ", sImIndex='" + sImIndex + '\'' +
                '}';
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getsImIndex() {
        return sImIndex;
    }

    public void setsImIndex(String sImIndex) {
        this.sImIndex = sImIndex;
    }
}
