package com.await.qq.bean;

import java.util.List;

public class TenCentBean {
    private String group_name;
    private String group_divider_yes,getGroup_divider_no;
    private List<TenCentBeanChild> mList;
    public TenCentBean(){

    }

    public TenCentBean(String group_name, String group_divider_yes, String getGroup_divider_no, List<TenCentBeanChild> mList) {
        this.group_name = group_name;
        this.group_divider_yes = group_divider_yes;
        this.getGroup_divider_no = getGroup_divider_no;
        this.mList = mList;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_divider_yes() {
        return group_divider_yes;
    }

    public void setGroup_divider_yes(String group_divider_yes) {
        this.group_divider_yes = group_divider_yes;
    }

    public String getGetGroup_divider_no() {
        return getGroup_divider_no;
    }

    public void setGetGroup_divider_no(String getGroup_divider_no) {
        this.getGroup_divider_no = getGroup_divider_no;
    }

    public List<TenCentBeanChild> getmList() {
        return mList;
    }

    public void setmList(List<TenCentBeanChild> mList) {
        this.mList = mList;
    }

    @Override
    public String toString() {
        return "TenCentBean{" +
                "group_name='" + group_name + '\'' +
                ", group_divider_yes='" + group_divider_yes + '\'' +
                ", getGroup_divider_no='" + getGroup_divider_no + '\'' +
                ", mList=" + mList +
                '}';
    }

    public class TenCentBeanChild{
        private int userIcon;
        private String user_type,user_name,user_online;

        public TenCentBeanChild() {
        }

        public TenCentBeanChild(int userIcon, String user_type, String user_name, String user_online) {
            this.userIcon = userIcon;
            this.user_type = user_type;
            this.user_name = user_name;
            this.user_online = user_online;
        }

        public int getUserIcon() {
            return userIcon;
        }

        public void setUserIcon(int userIcon) {
            this.userIcon = userIcon;
        }

        public String getUser_type() {
            return user_type;
        }

        public void setUser_type(String user_type) {
            this.user_type = user_type;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_online() {
            return user_online;
        }

        public void setUser_online(String user_online) {
            this.user_online = user_online;
        }

        @Override
        public String toString() {
            return "TenCentBeanChild{" +
                    "userIcon=" + userIcon +
                    ", user_type='" + user_type + '\'' +
                    ", user_name='" + user_name + '\'' +
                    ", user_online='" + user_online + '\'' +
                    '}';
        }
    }
}
