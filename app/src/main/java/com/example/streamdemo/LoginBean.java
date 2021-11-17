package com.example.streamdemo;

/**
 * @author: 小杨同志
 * @date: 2021/11/8
 */
public class LoginBean {

    /**
     * code : 200
     * msg : 登录成功
     * data : {"macAddress":"E8:5A:8B:95:24:28","endTime":"2024-11-08 00:00:00","remainingCount":100}
     * total : null
     */

    private int code;
    private String msg;
    private DataBean data;
    private Object total;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
        this.total = total;
    }

    public static class DataBean {
        /**
         * macAddress : E8:5A:8B:95:24:28
         * endTime : 2024-11-08 00:00:00
         * remainingCount : 100
         */

        private String macAddress;
        private String endTime;
        private int remainingCount;

        public String getMacAddress() {
            return macAddress;
        }

        public void setMacAddress(String macAddress) {
            this.macAddress = macAddress;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getRemainingCount() {
            return remainingCount;
        }

        public void setRemainingCount(int remainingCount) {
            this.remainingCount = remainingCount;
        }
    }
}
