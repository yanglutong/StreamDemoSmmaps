package com.example.streamdemo.nr_lte_cdma_gsm_info;



/**
 * @author: 小杨同志
 * @date: 2021/11/5
 */
public class CdmInfo {
    private int basestationId_bid;
    private int networkId_nid;
    private int systemId_sid;
    private int asuLevel;
    private int cdmaEcio;
    private int cdmaDbm;
    private int cdmaLevel;
    private int dbm;
    private int evdoSnr;
    private int level;
    private int evdoLevel;
    private int evdoDbm;
    private int evdoEcio;

    @Override
    public String toString() {
        return "CdmInfo{" +
                "basestationId_bid=" + basestationId_bid +
                ", networkId_nid=" + networkId_nid +
                ", systemId_sid=" + systemId_sid +
                ", asuLevel=" + asuLevel +
                ", cdmaEcio=" + cdmaEcio +
                ", cdmaDbm=" + cdmaDbm +
                ", cdmaLevel=" + cdmaLevel +
                ", dbm=" + dbm +
                ", evdoSnr=" + evdoSnr +
                ", level=" + level +
                ", evdoLevel=" + evdoLevel +
                ", evdoDbm=" + evdoDbm +
                ", evdoEcio=" + evdoEcio +
                '}'+"\r\n\r\n";
    }

    public int getBasestationId_bid() {
        return basestationId_bid;
    }

    public void setBasestationId_bid(int basestationId_bid) {
        this.basestationId_bid = basestationId_bid;
    }

    public int getNetworkId_nid() {
        return networkId_nid;
    }

    public void setNetworkId_nid(int networkId_nid) {
        this.networkId_nid = networkId_nid;
    }

    public int getSystemId_sid() {
        return systemId_sid;
    }

    public void setSystemId_sid(int systemId_sid) {
        this.systemId_sid = systemId_sid;
    }

    public int getAsuLevel() {
        return asuLevel;
    }

    public void setAsuLevel(int asuLevel) {
        this.asuLevel = asuLevel;
    }

    public int getCdmaEcio() {
        return cdmaEcio;
    }

    public void setCdmaEcio(int cdmaEcio) {
        this.cdmaEcio = cdmaEcio;
    }

    public int getCdmaDbm() {
        return cdmaDbm;
    }

    public void setCdmaDbm(int cdmaDbm) {
        this.cdmaDbm = cdmaDbm;
    }

    public int getCdmaLevel() {
        return cdmaLevel;
    }

    public void setCdmaLevel(int cdmaLevel) {
        this.cdmaLevel = cdmaLevel;
    }

    public int getDbm() {
        return dbm;
    }

    public void setDbm(int dbm) {
        this.dbm = dbm;
    }

    public int getEvdoSnr() {
        return evdoSnr;
    }

    public void setEvdoSnr(int evdoSnr) {
        this.evdoSnr = evdoSnr;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getEvdoLevel() {
        return evdoLevel;
    }

    public void setEvdoLevel(int evdoLevel) {
        this.evdoLevel = evdoLevel;
    }

    public int getEvdoDbm() {
        return evdoDbm;
    }

    public void setEvdoDbm(int evdoDbm) {
        this.evdoDbm = evdoDbm;
    }

    public int getEvdoEcio() {
        return evdoEcio;
    }

    public void setEvdoEcio(int evdoEcio) {
        this.evdoEcio = evdoEcio;
    }
}
