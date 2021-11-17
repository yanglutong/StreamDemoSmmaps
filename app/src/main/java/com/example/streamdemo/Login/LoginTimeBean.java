package com.example.streamdemo.Login;

/**根据用户查询剩余时间
 * @author: 小杨同志
 * @date: 2021/11/8
 */
public class LoginTimeBean {
    @Override
    public String toString() {
        return "LoginTimeBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", total=" + total +
                '}';
    }

    /**
     * code : 200
     * msg : 查询成功
     * data : {"endTime":"2023-11-08 00:00:00","userName":"yang"}
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
                    "endTime='" + endTime + '\'' +
                    ", userName='" + userName + '\'' +
                    '}';
        }

        /**
         * endTime : 2023-11-08 00:00:00
         * userName : yang
         */

        private String endTime;
        private String userName;

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
