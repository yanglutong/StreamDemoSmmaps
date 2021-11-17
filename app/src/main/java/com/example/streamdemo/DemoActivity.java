package com.example.streamdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.http.HttpRequestCallback;
import com.example.http.HttpUtils;
import com.example.location.Utils.DtUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.TreeMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        String address = DtUtils.getMacAddress(this);
        Log.e("TAG", "onCreate: "+address);
//        TreeMap<Object, String> map = new TreeMap<>();
//        map.put("username", "yang");
//        map.put("password", "yang");
//        map.put("macaddress", "E8:5A:8B:95:24:28");
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //通过FormBody对象构建Builder来添加表单参数
        FormBody mFormBody = new FormBody.Builder()
                .add("username","yang")
                .add("password","yang")
                .add("macaddress","E8:5A:8B:95:24:28")
                .build();

        Request mRequest = new Request.Builder()
                .url("http://39.107.141.215:8088/app/login")
                .post(mFormBody)
                .build();

        mOkHttpClient.newCall(mRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //响应失败
                Log.e("TAG", "onResponse: "+e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //响应成功
                Log.e("TAG", "onResponse: "+response.body().string());
            }
        });

    }
}