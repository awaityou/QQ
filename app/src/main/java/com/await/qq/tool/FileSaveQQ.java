package com.await.qq.tool;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用文件的形式对 username 和 passcode 进行存储
 */
public class FileSaveQQ {
    public static boolean saveUserInfo(Context context,String username,String passcode){
        FileOutputStream fileOutputStream = null;
        try {
            // 获取文件输出对象
            fileOutputStream = context.openFileOutput("data.txt",Context.MODE_PRIVATE);
            // 将数据转换为字节码形式写入到data.txt 文件中
            try {
                fileOutputStream.write((username+":"+passcode).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            try{
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Map<String, String> getUserInfo(Context context){
        String content = "";
        FileInputStream fileInputStream = null;

        try{
            // 获取文本对象
            fileInputStream = context.openFileInput("data.txt");
            byte[] buffer = new byte[fileInputStream.available()];
            // 读取文件中字节数据
            fileInputStream.read();
            content = new String(buffer);
            Map<String,String> userMap = new HashMap<>();
            String[] info = content.split(":");
            userMap.put("username",info[0]);
            userMap.put("passcode",info[1]);
            return userMap;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try{
                if (fileInputStream!=null){
                    fileInputStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
