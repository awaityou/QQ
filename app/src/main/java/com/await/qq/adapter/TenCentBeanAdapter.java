package com.await.qq.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.await.qq.R;
import com.await.qq.bean.TenCentBean;

import java.util.List;

public class TenCentBeanAdapter extends BaseExpandableListAdapter {
    private final List<TenCentBean> mList;
    private final LayoutInflater inflater;

    public TenCentBeanAdapter(List<TenCentBean> mList, Context context) {
        this.mList = mList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mList.get(groupPosition).getmList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mList.get(groupPosition).getmList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup viewHolderGroup = null;
        if (convertView == null) {

            convertView = inflater.inflate(R.layout.item_activity_expandable_list_view_group, parent, false);
            viewHolderGroup = new ViewHolderGroup();
            viewHolderGroup.group_icon = convertView.findViewById(R.id.group_icon);
            viewHolderGroup.group_divider = convertView.findViewById(R.id.group_divider);
            viewHolderGroup.group_name = convertView.findViewById(R.id.group_name);
            convertView.setTag(viewHolderGroup);
        } else {
            viewHolderGroup = (ViewHolderGroup) convertView.getTag();
        }
        TenCentBean tenCentBean = mList.get(groupPosition);
        if (isExpanded) {
            viewHolderGroup.group_icon.setImageResource(R.mipmap.focus);
        } else {
            viewHolderGroup.group_icon.setImageResource(R.mipmap.focusone);
        }
        viewHolderGroup.group_name.setText(tenCentBean.getGroup_name());
        viewHolderGroup.group_divider.setText(tenCentBean.getGroup_divider_yes() + "/" + tenCentBean.getGetGroup_divider_no());
        return convertView;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderChild viewHolderChild = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_activity_expandable_list_view_child, parent, false);
            viewHolderChild = new ViewHolderChild();
            viewHolderChild.user_icon = convertView.findViewById(R.id.user_icon);
            viewHolderChild.user_name = convertView.findViewById(R.id.user_name);
            viewHolderChild.user_type = convertView.findViewById(R.id.user_type);
            viewHolderChild.user_online = convertView.findViewById(R.id.user_online);
            convertView.setTag(viewHolderChild);
        } else {
            viewHolderChild = (ViewHolderChild) convertView.getTag();
        }
        TenCentBean.TenCentBeanChild tenCentBeanChild = mList.get(groupPosition).getmList().get(childPosition);
        viewHolderChild.user_icon.setImageResource(tenCentBeanChild.getUserIcon());
        viewHolderChild.user_type.setText("[" + tenCentBeanChild.getUser_type() + "]");
        viewHolderChild.user_name.setText(tenCentBeanChild.getUser_name());
        viewHolderChild.user_online.setText(tenCentBeanChild.getUser_online());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public static class ViewHolderGroup {
        public ImageView group_icon;
        public TextView group_divider;
        public TextView group_name;
    }

    public static class ViewHolderChild {
        public ImageView user_icon;
        public TextView user_name, user_type, user_online;
    }
}
