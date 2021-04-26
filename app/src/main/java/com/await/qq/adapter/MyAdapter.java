package com.await.qq.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.await.qq.bean.MyBean;
import com.await.qq.R;

import java.util.List;

public class MyAdapter extends BaseAdapter implements View.OnClickListener {
    private final List<MyBean> myBeanList;
    /*布局加载器*/
    private final LayoutInflater inflater;

    public MyAdapter(Context context, List<MyBean> myBeanList) {
        inflater = LayoutInflater.from(context);
        this.myBeanList = myBeanList;
    }

    @Override
    public int getCount() {
        return myBeanList == null ? 0 : myBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return myBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_activity_my_list_view, null);
            viewHolder.icon = convertView.findViewById(R.id.icon);
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.content = convertView.findViewById(R.id.content);


            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        MyBean myBean = myBeanList.get(position);
        viewHolder.icon.setImageResource(myBean.getIcon());
        viewHolder.name.setText(myBean.getName());
        viewHolder.content.setText(myBean.getContent());



        viewHolder.icon.setOnClickListener(this);
        viewHolder.icon.setTag(position);


        return convertView;




    }





    public static class ViewHolder {
        ImageView icon;
        TextView name;
        TextView content;
    }


    /*定义接口*/
    public interface MyItem {
        void item(View v);
    }

    private MyItem i ;

    public void setI(MyItem i){
        this.i = i;
    }
    @Override
    public void onClick(View v) {
        i.item(v);
    }

}
