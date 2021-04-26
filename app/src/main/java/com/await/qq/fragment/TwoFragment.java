package com.await.qq.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.await.qq.MyExpandableListViewActivity;
import com.await.qq.MyListViewActivity;
import com.await.qq.R;

public class TwoFragment extends Fragment implements View.OnClickListener {
    private View inflate;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflate = inflater.inflate(R.layout.item_activity_expandable_list_view_group, null);

        initListener();
        initView();
        return inflate;
    }

    private void initListener() {
        imageView = inflate.findViewById(R.id.group_icon);
    }

    private void initView() {
        imageView.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.group_icon:
                Intent intent = new Intent(getActivity(), MyExpandableListViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
