package com.await.qq.bean;

public class MyBean {

    private int icon;
    private String name,content;

    public MyBean(){}

    public MyBean(int icon, String name, String content) {
        this.icon = icon;
        this.name = name;
        this.content = content;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
