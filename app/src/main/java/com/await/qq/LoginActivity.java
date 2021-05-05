package com.await.qq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity implements View.OnClickListener {

    /**
     * chau
     */


    private static final String TAG = "221312";
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        initView();
        initLister();

    }
    // 初始化
    private void initView(){
        button = findViewById(R.id.login);

    }
    // 添加监听
    private void initLister(){
        button.setOnClickListener(this);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Log.i(TAG, "onClick: login");
                Toast.makeText(this,"点击了登录按钮",Toast.LENGTH_SHORT).show();
                // 登录页面跳转到列表页
                Intent intent = new Intent( this,MyFragmentActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }


    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     */
    private void loginData(){
        Intent intent = new Intent();
        intent.setClass(this,MainActivity.class);
        intent.putExtra("username","root");
        intent.putExtra("passcode","10086");
        startActivity(intent);
    }

}
