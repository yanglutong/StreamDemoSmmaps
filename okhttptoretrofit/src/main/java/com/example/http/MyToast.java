package com.example.http;

import android.content.Context;
import android.widget.Toast;

/**
 * @author: 小杨同志
 * @date: 2021/10/29
 */
public class MyToast {
    public static void showCenterSortToast(Context context,String msg){
        Toast.makeText(context, ""+msg, Toast.LENGTH_SHORT).show();
    }
}
