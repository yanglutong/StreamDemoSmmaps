package com.example.streamdemo.register;

/**
 * @author: 小杨同志
 * @date: 2021/11/15
 */
public class RegisterBean {
    @Override
    public String toString() {
        return "RegisterBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", total=" + total +
                '}';
    }

    /**
     * code : 200
     * msg : 更新成功
     * data : {"current":1,"size":10,"id":5,"userName":"yyds","passWord":"c4ca4238a0b923820dcc509a6f75849b","totalCount":11,"remainingCount":111,"company":"1","linkName":"1","linkPhone":"18158276032","status":0,"updateTime":"2021-11-12 16:17:54","createTime":"2021-11-12 16:17:54","endTime":"2023-11-12 00:00:00","macAddress":""}
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
                    ", userName='" + userName + '\'' +
                    ", passWord='" + passWord + '\'' +
                    ", totalCount=" + totalCount +
                    ", remainingCount=" + remainingCount +
                    ", company='" + company + '\'' +
                    ", linkName='" + linkName + '\'' +
                    ", linkPhone='" + linkPhone + '\'' +
                    ", status=" + status +
                    ", updateTime='" + updateTime + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", macAddress='" + macAddress + '\'' +
                    '}';
        }

        /**
         * current : 1
         * size : 10
         * id : 5
         * userName : yyds
         * passWord : c4ca4238a0b923820dcc509a6f75849b
         * totalCount : 11
         * remainingCount : 111
         * company : 1
         * linkName : 1
         * linkPhone : 18158276032
         * status : 0
         * updateTime : 2021-11-12 16:17:54
         * createTime : 2021-11-12 16:17:54
         * endTime : 2023-11-12 00:00:00
         * macAddress :
         */

        private int current;
        private int size;
        private int id;
        private String userName;
        private String passWord;
        private int totalCount;
        private int remainingCount;
        private String company;
        private String linkName;
        private String linkPhone;
        private int status;
        private String updateTime;
        private String createTime;
        private String endTime;
        private String macAddress;

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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getRemainingCount() {
            return remainingCount;
        }

        public void setRemainingCount(int remainingCount) {
            this.remainingCount = remainingCount;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getLinkName() {
            return linkName;
        }

        public void setLinkName(String linkName) {
            this.linkName = linkName;
        }

        public String getLinkPhone() {
            return linkPhone;
        }

        public void setLinkPhone(String linkPhone) {
            this.linkPhone = linkPhone;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getMacAddress() {
            return macAddress;
        }

        public void setMacAddress(String macAddress) {
            this.macAddress = macAddress;
        }
    }
}
