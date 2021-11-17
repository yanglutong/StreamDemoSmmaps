package com.example.http;

import android.content.Context;
import android.util.Log;

import java.util.TreeMap;

/**
 * @author: 小杨同志
 * @date: 2021/10/29
 */
public class Main {
    public void retrofit(Context context){
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("x", "1cc-0-31FB-4E40-0");
        map.put("p", "1");
        HttpRetrofitRequest.getInstances().mHttpPost(context, "http://39.107.141.215:8088/cw/post", map, 10, new HttpRequestCallback() {
            @Override
            public void onRequestNetFail(int type) {

            }

            @Override
            public void onRequestSuccess(String result, int type) {
//                Log.e(TAG, "onRequestSuccess: "+result );
            }

            @Override
            public void onRequestFail(String value,  int type) {

            }
        });
    }
    public void okHttp(Context context){
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("x", "1cc-0-31FB-4E40-0");
        map.put("p", "1");
        HttpUtils.getInstance().executePost(context, "http://39.107.141.215:8088/cw/post",
                map, 0, new HttpRequestCallback() {
                    @Override
                    public void onRequestNetFail(int type) {
//                        Log.e(TAG, "onRequestNetFail: "+type );
                    }

                    @Override
                    public void onRequestSuccess(String result, int type) {
//                        Log.e(TAG, "onRequestSuccess: "+result+type );
                    }

                    @Override
                    public void onRequestFail(String value, int type) {
//                        Log.e(TAG, "onRequestFail: "+value+failCode+type );
                    }
                });
    }
}
