package com.await.qq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;

import com.await.qq.adapter.MyAdapter;
import com.await.qq.bean.MyBean;
import com.await.qq.tool.MyImageDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyListViewActivity extends Activity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener, MyAdapter.MyItem {


    private ListView mListView;
    ImageView imageAvator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);
        initView();
        //initSimpleAdapter();
        initMyAdapter();
        initItemClickListener();

    }

    private void initView() {
        mListView = findViewById(R.id.list_view);
    }

    private void initSimpleAdapter() {
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, getData(),
                R.layout.item_activity_my_list_view, new String[]{"icon", "name", "content"},
                new int[]{R.id.icon, R.id.name, R.id.content});
        mListView.setAdapter(simpleAdapter);

    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        map.put("icon", R.mipmap.qq_48);
        map.put("name", "R.mipmap.qq_48");
        map.put("content", "this is helloWorld");
        mapList.add(map);

        map = new HashMap<>();
        map.put("icon", R.mipmap.qq_48);
        map.put("name", "R.mipmap.logo");
        map.put("content", "R.mipmap.logo");
        mapList.add(map);

        return mapList;
    }

    private void initMyAdapter() {
        MyAdapter myAdapter = new MyAdapter(this, getDataOther());
        mListView.setAdapter(myAdapter);
        myAdapter.setI(this);
    }

    private List<MyBean> getDataOther() {
        List<MyBean> myBeanList = new ArrayList<>();
        /*时间递减*/
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        System.out.println("当前时间：" + sdf.format(now));

        for (int i = 0; i < 9; i++) {

            Date afterDate = new Date(now.getTime() - 600000 * i);
            MyBean myBean = new MyBean();
            myBean.setIcon(R.mipmap.logo + i);
            myBean.setName("我的第" + (i + 1) + "个好友");
            myBean.setContent("我没有签名    " + sdf.format(afterDate));
            myBeanList.add(myBean);

        }
        System.out.println(myBeanList);
        return myBeanList;
    }


    private void initItemClickListener() {
        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("TAG", "onItemClick: " + position);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("TAG", "onItemClick: " + position);
        return true;
    }


    @Override
    public void item(View v) {
        Log.e("t", "eeee");
        int a;


        a = (int) v.getTag();


            imageAvator = findViewById(R.id.icon);
            Log.e("123456", a + "");
        for (int i = 0; i < 9; i++) {
            if (a == i) {
                imageAvator.setDrawingCacheEnabled(true);
                MyImageDialog myImageDialog = new MyImageDialog(this, R.style.dialogWindowAnim, 0, -300, imageAvator.getDrawingCache());

                myImageDialog.show();
                Log.e("Tag", "---end--");
            }
        }

    }

}






