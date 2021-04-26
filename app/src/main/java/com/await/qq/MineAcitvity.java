package com.await.qq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class MineAcitvity extends Activity {
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
    }
}
