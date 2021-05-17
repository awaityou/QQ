package com.await.qq.tool;

import cn.hutool.captcha.*;

public class CaptchaUtils {

    public static void getCaptcha(){
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

//图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("d:/line.png");
//输出code
        System.out.println(lineCaptcha.getCode());
//验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");

//重新生成验证码
        lineCaptcha.createCode();
        lineCaptcha.write("d:/line.png");
//新的验证码
        System.out.println(lineCaptcha.getCode());
//验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");

    }
}
