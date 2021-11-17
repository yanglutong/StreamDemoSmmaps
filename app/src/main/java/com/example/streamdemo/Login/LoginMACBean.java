package com.example.streamdemo.Login;


/**查询当前用户MAC地址
 * @author: 小杨同志
 * @date: 2021/11/9
 */
public class LoginMACBean {
    @Override
    public String toString() {
        return "LoginMACBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", total=" + total +
                '}';
    }

    /**
     * code : 200
     * msg : 查询成功
     * data : {"macAddress":"E8:5A:8B:95:24:28","endTime":"2023-11-08 00:00:00","userName":"yang"}
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
                    "macAddress='" + macAddress + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", userName='" + userName + '\'' +
                    '}';
        }

        /**
         * macAddress : E8:5A:8B:95:24:28
         * endTime : 2023-11-08 00:00:00
         * userName : yang
         */

        private String macAddress;
        private String endTime;
        private String userName;

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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
