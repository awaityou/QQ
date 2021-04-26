package com.await.qq;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import androidx.annotation.Nullable;

import com.await.qq.adapter.TenCentBeanAdapter;
import com.await.qq.bean.TenCentBean;

import java.util.ArrayList;
import java.util.List;

public class MyExpandableListViewActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        initView();
    }

    private void initView() {
        ExpandableListView expandableListView = findViewById(R.id.expand_activities_button);
        TenCentBeanAdapter tenCentBeanAdapter = new TenCentBeanAdapter(getData(),this);
        expandableListView.setAdapter(tenCentBeanAdapter);
    }

    private List<TenCentBean> getData() {
        List<TenCentBean> mList = new ArrayList<>();
        TenCentBean tenCentBean = new TenCentBean();
        tenCentBean.setGroup_name("分组1");
        tenCentBean.setGroup_divider_yes("20");
        tenCentBean.setGetGroup_divider_no("100");
        List<TenCentBean.TenCentBeanChild> childList = new ArrayList<>();
        TenCentBean.TenCentBeanChild tenCentBeanChild = tenCentBean.new TenCentBeanChild();
        tenCentBeanChild.setUserIcon(R.mipmap.logo0);
        tenCentBeanChild.setUser_name("张三");
        tenCentBeanChild.setUser_type("2G");
        tenCentBeanChild.setUser_online("this is english speaking");
        childList.add(tenCentBeanChild);

        tenCentBeanChild = tenCentBean.new TenCentBeanChild();
        tenCentBeanChild.setUserIcon(R.mipmap.logo4);
        tenCentBeanChild.setUser_name("李四");
        tenCentBeanChild.setUser_type("5G");
        tenCentBeanChild.setUser_online("1111111111111111111111111");
        childList.add(tenCentBeanChild);


        tenCentBean.setmList(childList);
        mList.add(tenCentBean);
        Log.e("TAG", "getData: " + mList);

        return  mList;
    }
}
