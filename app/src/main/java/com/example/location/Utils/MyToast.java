package com.example.location.Utils;

import android.content.Context;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.location.AppLication;
import com.example.streamdemo.R;


public class MyToast {
    //    //居中 自定义布局Toast
    public static void showToast(String text) {

        Context contexts = AppLication.getContexts();
        try {
            Toast toast = Toast.makeText(contexts, text, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, -250);

            View view = LayoutInflater.from(contexts).inflate(R.layout.toast_item, null);
            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(text + "");
            toast.setView(view);
            toast.show();
        } catch (Exception e) {
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast.makeText(contexts, text, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }

    }
}
