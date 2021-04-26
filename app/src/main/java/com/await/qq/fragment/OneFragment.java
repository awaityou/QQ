package com.await.qq.fragment;

import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.await.qq.MyListViewActivity;
import com.await.qq.R;


public class OneFragment extends Fragment implements View.OnClickListener{
    private View inflate;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflate = inflater.inflate(R.layout.activity_login,null);
        Log.e("aaa",inflate.toString());
        initView();
        initListener();
        return inflate;
    }

    private void initListener() {
        imageView.setOnClickListener(this);

    }

    private void initView() {
        imageView = inflate.findViewById(R.id.qq);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Log.e("Onclick","方法");
        switch (v.getId()){

            case R.id.qq:
                Log.e("Onclick","case");
                Intent intent = new Intent(getActivity(), MyListViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
