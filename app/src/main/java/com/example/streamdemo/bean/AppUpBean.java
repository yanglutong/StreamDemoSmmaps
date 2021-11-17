package com.example.streamdemo.bean;

/**
 * @author: 小杨同志
 * @date: 2021/11/11
 */
public class AppUpBean {
    @Override
    public String toString() {
        return "AppUpBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", total=" + total +
                '}';
    }

    /**
     * code : 200
     * msg : 请求成功
     * data : {"current":1,"size":10,"id":1,"appName":"香港apk","versionCode":"1.0","versionName":"193","appType":1,"appSize":"50M","newFunction":"新功能：1. 当前用户使用有效期限 2.部分功能的优化","dlCount":5,"createTime":"2021-10-28 12:22:33","appPath":"base.apk"}
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
        @Override
        public String toString() {
            return "DataBean{" +
                    "current=" + current +
                    ", size=" + size +
                    ", id=" + id +
                    ", appName='" + appName + '\'' +
                    ", versionCode='" + versionCode + '\'' +
                    ", versionName='" + versionName + '\'' +
                    ", appType=" + appType +
                    ", appSize='" + appSize + '\'' +
                    ", newFunction='" + newFunction + '\'' +
                    ", dlCount=" + dlCount +
                    ", createTime='" + createTime + '\'' +
                    ", appPath='" + appPath + '\'' +
                    '}';
        }

        /**
         * current : 1
         * size : 10
         * id : 1
         * appName : 香港apk
         * versionCode : 1.0
         * versionName : 193
         * appType : 1
         * appSize : 50M
         * newFunction : 新功能：1. 当前用户使用有效期限 2.部分功能的优化
         * dlCount : 5
         * createTime : 2021-10-28 12:22:33
         * appPath : base.apk
         */

        private int current;
        private int size;
        private int id;
        private String appName;
        private String versionCode;
        private String versionName;
        private int appType;
        private String appSize;
        private String newFunction;
        private int dlCount;
        private String createTime;
        private String appPath;

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(String versionCode) {
            this.versionCode = versionCode;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public int getAppType() {
            return appType;
        }

        public void setAppType(int appType) {
            this.appType = appType;
        }

        public String getAppSize() {
            return appSize;
        }

        public void setAppSize(String appSize) {
            this.appSize = appSize;
        }

        public String getNewFunction() {
            return newFunction;
        }

        public void setNewFunction(String newFunction) {
            this.newFunction = newFunction;
        }

        public int getDlCount() {
            return dlCount;
        }

        public void setDlCount(int dlCount) {
            this.dlCount = dlCount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getAppPath() {
            return appPath;
        }

        public void setAppPath(String appPath) {
            this.appPath = appPath;
        }
    }
}
