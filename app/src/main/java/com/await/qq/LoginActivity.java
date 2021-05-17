package com.await.qq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.await.qq.tool.FileSaveQQ;

import java.util.Map;

public class LoginActivity extends Activity implements View.OnClickListener {
    /**
     * 账号输入框
     */

    private EditText et_passcode;
    private EditText et_username;

    /**
     *  定义文本框右边的提示信息
     */
    private ImageView passCodeImageView;
    private ImageView userDelImageView;
    private ImageView passCodeEyesImageView;

    private static final String TAG = "221312";
    private Button buttonLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 通过工具类对账号密码进行比对
        Map<String, String> userInfo = FileSaveQQ.getUserInfo(this);
        if (userInfo != null) {
            et_passcode.setText(userInfo.get("passcode"));
            et_username.setText(userInfo.get("username"));
        }
        setContentView(R.layout.activity_login);
        initView();
        initLister();

        /*初始化登录按钮不可点击*/
        buttonLogin.setClickable(false);

    }

    // 测试github

    // 初始化控件
    private void initView() {
        buttonLogin = findViewById(R.id.login);
        et_username = findViewById(R.id.user_edit);
        et_passcode = findViewById(R.id.pass_edit);
        // 三个图片控件
        userDelImageView = findViewById(R.id.user_del);

    }

    // 添加监听
    private void initLister() {
        buttonLogin.setOnClickListener(this);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                // 登陆验证
                String username = et_username.getText().toString().trim();
                String passcode = et_passcode.getText().toString();
                if (loginVerification(username, passcode)) {
                    Log.i(TAG, "onClick: login");
                    Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                    // 登录页面跳转到列表页
                    Intent intent = new Intent(this, MyFragmentActivity.class);
                    startActivity(intent);
                    break;
                }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }


    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     */
    private void loginData() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.putExtra("username", "root");
        intent.putExtra("passcode", "10086");
        startActivity(intent);
    }

    /**
     * 对登录进行验证
     */

    private boolean loginVerification(String username, String passcode) {
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "用户名为空", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(passcode)) {
            Toast.makeText(this, "密码为空", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }

    }

}


















