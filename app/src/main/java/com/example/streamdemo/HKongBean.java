package com.example.streamdemo;

/**用于网络请求数据的bean类
 * @author: 小杨同志
 * @date: 2021/11/1
 */
public class HKongBean {

    /**
     * address :
     * cause : OK
     * lon : 114.45060867793751
     * time :
     * radius : 550
     * type : cell
     * map : baidu
     * lat : 38.03038914763157
     * status : 0
     */

    private String address;
    private String cause;
    private double lon;
    private String time;
    private int radius;
    private String type;
    private String map;
    private double lat;
    private int status;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HKongBean{" +
                "address='" + address + '\'' +
                ", cause='" + cause + '\'' +
                ", lon=" + lon +
                ", time='" + time + '\'' +
                ", radius=" + radius +
                ", type='" + type + '\'' +
                ", map='" + map + '\'' +
                ", lat=" + lat +
                ", status=" + status +
                '}';
    }
}
