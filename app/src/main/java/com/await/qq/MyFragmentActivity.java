package com.await.qq;


import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.await.qq.fragment.OneFragment;
import com.await.qq.fragment.TwoFragment;


public class MyFragmentActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private FrameLayout frameLayout;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
        initView();
        initFragment();
        initListener();
    }

    private void initListener() {
        radioGroup.setOnCheckedChangeListener(this);
    }


    private void initFragment() {
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        addFragment(oneFragment);
        addFragment(twoFragment);

        hideFragment(oneFragment);
        hideFragment(twoFragment);

        showFragment(oneFragment);
    }

    private void initView() {
        frameLayout = findViewById(R.id.list_fr_view);
        radioGroup = findViewById(R.id.rg_01);
    }

    /**
     * <p>Called when the checked radio button has changed. When the
     * selection is cleared, checkedId is -1.</p>
     *
     * @param group     the group in which the checked radio button has changed
     * @param checkedId the unique identifier of the newly checked radio button
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_01:
                mHideFragment();
                showFragment(oneFragment);
                break;
            case R.id.rb_02:
                mHideFragment();
                showFragment(twoFragment);
                break;
            case R.id.rb_04:
                break;
        }
    }
    /**
     * 下面是 添加 显示 隐藏 加载
     */
    private void addFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().add(R.id.list_fr_view,fragment).commit();

    }
    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    private void mHideFragment() {

        hideFragment(oneFragment);
        hideFragment(twoFragment);
    }

    private void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }


}
